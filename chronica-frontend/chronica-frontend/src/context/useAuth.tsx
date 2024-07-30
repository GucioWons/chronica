import React, {createContext, useCallback, useEffect, useState} from "react";
import {useNavigate} from "react-router";
import axios from "axios";
import {usersApi} from "../shared/apiConstants";

export interface PersonDTO {
    name: string,
    lastName: string,
    age: number
}

export interface AccountDTO {
    username: string,
    mail: string,
    phoneNumber: number,
    password: string,
    person: PersonDTO;
}

export interface SignInDTO {
    mail: string;
    password: string;
}

interface UserContext {
    account: AccountDTO | null,
    token: string | null,
    registerUser: (dto: AccountDTO) => void,
    loginUser: (dto: SignInDTO) => void,
    // logoutUser: () => void,
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
        }
        setReady(true);
    }, []);

    const registerUser = useCallback((dto: AccountDTO) => {
        axios.post(usersApi + "/accounts/sign-up", {...dto})
            .then(response => console.log(response.data))
            .catch(() => console.log("Error"));
    }, []);

    const loginUser = useCallback((dto: SignInDTO) => {
        axios.post(usersApi + "/accounts/sign-in", {...dto})
            .then(response => {
                setAccount({mail: "", password: "", person: { name: "", lastName: "", age: 0 }, phoneNumber: 0, username: ""});
            })
            .catch(() => console.log("Error"));
    }, []);

    const isLoggedIn = useCallback(() => {
        return !(account === null || account === undefined);
    }, []);

    return (
        <UserContext.Provider value={{ account, token, registerUser, loginUser, isLoggedIn }}>
            {ready ? props.children : null}
        </UserContext.Provider>
    )
};

export const useAuth = () => React.useContext(UserContext);