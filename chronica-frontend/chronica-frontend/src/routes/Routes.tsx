import {createBrowserRouter} from "react-router-dom";
import App from "../App";
import AuthorizationPage from "../pages/authorization/AuthorizationPage";

export const router = createBrowserRouter(
    [
        {
            path: "/",
            element: <App />,
            children: [
                {
                    path: "/auth",
                    element: <AuthorizationPage />
                }
            ]
        },
    ]
)