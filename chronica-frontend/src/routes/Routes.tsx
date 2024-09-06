import {createBrowserRouter} from "react-router-dom";
import App from "../App";
import AuthorizationPage from "../pages/authorization/AuthorizationPage";
import HomePage from "../pages/home/HomePage";
import ConfirmationPage from "../pages/authorization/ConfirmationPage";
import GroupDetailPage from "../pages/group/detail/GroupDetailPage";
import GroupEditPage from "../pages/group/edit/GroupEditPage";
import GroupCreatePage from "../pages/group/create/GroupCreatePage";

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
                    path: "confirmation/:confirmation",
                    element: <ConfirmationPage />
                },
                {
                    path: "groups/:id",
                    element: <GroupDetailPage />
                },
                {
                    path: "groups/:id/edit",
                    element: <GroupEditPage />
                },
                {
                    path: "groups/new",
                    element: <GroupCreatePage />
                }
            ]
        },
    ]
)