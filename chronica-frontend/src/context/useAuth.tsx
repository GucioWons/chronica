import React, {createContext, useEffect, useState} from "react";
import {useNavigate} from "react-router";
import axios from "axios";
import {usersApi} from "../shared/apiConstants";
import {toast} from "react-toastify";
import {DTOs} from "../shared/dto/dtos";
import AccountDTO = DTOs.AccountDTO;
import SignInDTO = DTOs.SignInDTO;
import SignInResultDTO = DTOs.SignInResultDTO;

interface UserContext {
    account: AccountDTO | null,
    token: string | null,
    registerUser: (dto: AccountDTO) => void,
    loginUser: (dto: SignInDTO) => void,
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

    useEffect(() => {
        const account = localStorage.getItem("account");
        const token = localStorage.getItem("token");
        if (account && token) {
            setAccount(JSON.parse(account));
            setToken(token);
            axios.defaults.headers.common["Authorization"] = "Bearer " + token;
        }
        setReady(true);
    }, []);

    const registerUser = (dto: AccountDTO) => {
        axios.post(usersApi + "/accounts/sign-up", {...dto})
            .then(() => toast.success("Successfully registered account!"))
            .catch(() => toast.error("Cannot register account"));
    }

    const loginUser = (dto: SignInDTO) => {
        axios.post<SignInResultDTO>(usersApi + "/accounts/sign-in", {...dto})
            .then(response => {
                localStorage.setItem("token", response.data.token);
                localStorage.setItem("account", JSON.stringify(response.data.account));
                setToken(response.data.token);
                setAccount(response.data.account)
                axios.defaults.headers.common["Authorization"] = "Bearer " + token;
                toast.success("Successfully logged in!")
                navigate("/");
            })
            .catch(() => toast.error("Cannot login!"));
    }

    const logoutUser = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("account");
        setToken(null);
        setAccount(null);
        toast.success("Successfully logged out!")
        navigate("/auth")
    }

    const isLoggedIn = () => {
        return !!account;
    }

    return (
        <UserContext.Provider value={{ account, token, registerUser, loginUser, logoutUser, isLoggedIn }}>
            {ready ? props.children : null}
        </UserContext.Provider>
    )
};

export const useAuth = () => React.useContext(UserContext);