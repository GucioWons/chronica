import React, {createContext, useEffect, useState} from "react";
import {useNavigate} from "react-router";
import axios, {AxiosError, InternalAxiosRequestConfig} from "axios";
import {toast} from "react-toastify";
import {DTOs} from "../shared/dto/dtos";
import AccountDTO = DTOs.AccountDTO;
import SignInDTO = DTOs.SignInDTO;
import SignInResultDTO = DTOs.SignInResultDTO;
import {userApi} from "../shared/apiConstants";
import {useErrorHandler} from "../shared/http/handleError";
import {setupAxiosInterceptor} from "../shared/http/axiosInterceptor";

interface UserContext {
    account: AccountDTO | null,
    token: string | null,
    registerUser: (dto: AccountDTO) => void,
    loginUser: (dto: SignInDTO) => void,
    refreshToken: (requestConfig: InternalAxiosRequestConfig) => Promise<void>,
    logoutUser: () => void,
    isLoggedIn: () => boolean,
}

const UserContext = createContext<UserContext>({} as UserContext);

interface UserProviderProps {
    children: React.ReactNode
}

export const UserProvider = (props: UserProviderProps) => {
    const navigate = useNavigate();

    const [token, setToken] = useState<string | null>(null);
    const [account, setAccount] = useState<AccountDTO | null>(null);
    const [ready, setReady] = useState(false);

    const handleError = useErrorHandler();

    useEffect(() => {
        const account = localStorage.getItem("account");
        const token = localStorage.getItem("token");
        if (account && token) {
            setAccount(JSON.parse(account));
            setToken(token);
            axios.defaults.headers.common["Authorization"] = "Bearer " + token;
        }
        setReady(true);

        setupAxiosInterceptor(refreshToken);
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    const registerUser = (dto: AccountDTO) => {
        axios.post(userApi + "/sign-up", {...dto})
            .then(() => toast.success("Successfully registered account!"))
            .catch((error) => handleError(error));
    }

    const loginUser = (dto: SignInDTO) => {
        axios.post<SignInResultDTO>(userApi + "/sign-in", {...dto})
            .then(response => {
                updateAccountAndTokens(response.data);
                toast.success("Successfully logged in!");
                navigate("/");
            })
            .catch((error) => handleError(error));
    }

    const refreshToken = (requestConfig: InternalAxiosRequestConfig): Promise<void> => {
        const tokenToRefresh = localStorage.getItem("refreshToken");

        if (!tokenToRefresh) {
            logoutUser();
            return Promise.reject(new Error("No refresh token available"));
        }

        return axios.post<SignInResultDTO>(userApi + `/refresh-token`, {}, {
            headers: {
                Authorization: undefined
            },
            params: {
                token: tokenToRefresh
            }
        })
            .then((response) => {
                updateAccountAndTokens(response.data);
                if (requestConfig) {
                    requestConfig.headers["Authorization"] = `Bearer ${response.data.token}`;
                }
            })
            .catch((error) => {
                logoutUser();
                return Promise.reject(error);
            });
    }

    const updateAccountAndTokens = (signInResult: SignInResultDTO) => {
        localStorage.setItem("token", signInResult.token);
        localStorage.setItem("refreshToken", signInResult.refreshToken);
        localStorage.setItem("account", JSON.stringify(signInResult.account));
        setToken(signInResult.token);
        setAccount(signInResult.account);
        axios.defaults.headers.common["Authorization"] = "Bearer " + token;
    }

    const logoutUser = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("refreshToken")
        localStorage.removeItem("account");
        setToken(null);
        setAccount(null);
        delete axios.defaults.headers.common["Authorization"];
        toast.info("You have been logged out!")
        navigate("/auth")
    }

    const isLoggedIn = () => {
        return !!account;
    }

    return (
        <UserContext.Provider value={{ account, token, registerUser, loginUser, refreshToken, logoutUser, isLoggedIn }}>
            {ready ? props.children : null}
        </UserContext.Provider>
    )
};

export const useAuth = () => React.useContext(UserContext);