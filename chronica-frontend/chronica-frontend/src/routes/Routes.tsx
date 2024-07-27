import {createBrowserRouter} from "react-router-dom";
import App from "../App";
import AuthorizationPage from "../pages/authorization/AuthorizationPage";
import HomePage from "../pages/home/HomePage";
import ConfirmationPage from "../pages/authorization/ConfirmationPage";

export const router = createBrowserRouter(
    [
        {
            path: "/",
            element: <App />,
            children: [
                {
                    path: "",
                    element: <HomePage />
                },
                {
                    path: "auth",
                    element: <AuthorizationPage />
                },
                {
                    path: "confirmation/:confirmation", // Dodajemy ścieżkę z parametrem
                    element: <ConfirmationPage />
                }
            ]
        },
    ]
)