import {createContext} from "react";

export interface UserProfile{
    email: string,
    username: string,
    token: string,
    registerUser: () => void,
    loginUser: () => void,
    logoutUser: () => void,
    isLoggedIn: () => boolean,
}

const UserContext = createContext<UserProfile>({} as UserProfile);