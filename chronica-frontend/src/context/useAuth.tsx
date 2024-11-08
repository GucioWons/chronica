import React, {createContext, useEffect, useState} from "react";
import {useNavigate} from "react-router";
import axios from "axios";
import {toast} from "react-toastify";
import {DTOs} from "../shared/dto/dtos";
import AccountDTO = DTOs.AccountDTO;
import SignInDTO = DTOs.SignInDTO;
import SignInResultDTO = DTOs.SignInResultDTO;
import {userApi} from "../shared/apiConstants";
import {useErrorHandler} from "../shared/http/handleError";

interface UserContext {
    account: AccountDTO | null,
    token: string | null,
    registerUser: (dto: AccountDTO) => void,
    loginUser: (dto: SignInDTO) => void,
    refreshUsersToken: () => void,
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
    const [refreshToken, setRefreshToken] = useState<string | null>(null);
    const [account, setAccount] = useState<AccountDTO | null>(null);
    const [ready, setReady] = useState(false);

    const handleError = useErrorHandler();

    useEffect(() => {
        const account = localStorage.getItem("account");
        const token = localStorage.getItem("token");
        const refreshToken = localStorage.getItem("refreshToken")
        if (account && token && refreshToken) {
            setAccount(JSON.parse(account));
            setToken(token);
            setRefreshToken(refreshToken)
            axios.defaults.headers.common["Authorization"] = "Bearer " + token;
        }
        setReady(true);
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

    const refreshUsersToken = () => {
        axios.post<SignInResultDTO>(userApi + `/refresh-token?token=${refreshToken}`)
            .then((response) => updateAccountAndTokens(response.data))
            .catch(() => logoutUser());
    }

    const updateAccountAndTokens = (signInResult: SignInResultDTO) => {
        localStorage.setItem("token", signInResult.token);
        localStorage.setItem("refreshToken", signInResult.refreshToken);
        localStorage.setItem("account", JSON.stringify(signInResult.account));
        setToken(signInResult.token);
        setRefreshToken(signInResult.refreshToken);
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
        toast.info("Successfully logged out!")
        navigate("/auth")
    }

    const isLoggedIn = () => {
        return !!account;
    }

    return (
        <UserContext.Provider value={{ account, token, registerUser, loginUser, refreshUsersToken, logoutUser, isLoggedIn }}>
            {ready ? props.children : null}
        </UserContext.Provider>
    )
};

export const useAuth = () => React.useContext(UserContext);