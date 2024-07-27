import {createBrowserRouter} from "react-router-dom";
import App from "../App";
import AuthorizationPage from "../pages/authorization/AuthorizationPage";
import HomePage from "../pages/home/HomePage";
import ConfirmationPage from "../pages/authorization/ConfirmationPage";
import ProtectedRoute from "./ProtectedRoute";

export const router = createBrowserRouter(
    [
        {
            path: "/",
            element: <App />,
            children: [
                {
                    path: "",
                    element: <ProtectedRoute><HomePage /></ProtectedRoute>
                },
                {
                    path: "auth",
                    element: <AuthorizationPage />
                },
                {
                    path: "confirmation/:confirmation",
                    element: <ConfirmationPage />
                }
            ]
        },
    ]
)