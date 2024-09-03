import {createBrowserRouter} from "react-router-dom";
import App from "../App";
import AuthorizationPage from "../pages/authorization/AuthorizationPage";
import HomePage from "../pages/home/HomePage";
import ConfirmationPage from "../pages/authorization/ConfirmationPage";
import GroupPage from "../pages/group/detail/GroupPage";
import GroupEditPage from "../pages/group/edit/GroupEditPage";
import GroupCreatePage from "../pages/group/create/GroupCreatePage";
import ProjectListPage from "../pages/project/list/ProjectListPage";
import ProjectDetailPage from "../pages/project/detail/ProjectDetailPage";

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
                    path: "group/:id",
                    element: <GroupPage />
                },
                {
                    path: "group/:id/edit",
                    element: <GroupEditPage />
                },
                {
                    path: "group/new",
                    element: <GroupCreatePage />
                },
                {
                    path: "projects",
                    element: <ProjectListPage />
                },
                {
                    path: "projects/:id",
                    element: <ProjectDetailPage />
                }
            ]
        },
    ]
)