import {createBrowserRouter} from "react-router-dom";
import App from "../App";
import AuthorizationPage from "../pages/authorization/AuthorizationPage";
import HomePage from "../pages/home/HomePage";
import ConfirmationPage from "../pages/authorization/ConfirmationPage";
import GroupDetailPage from "../pages/group/detail/GroupDetailPage";
import NotificationListPage from "../pages/notification/list/NotificationListPage";
import GroupEditPage from "../pages/group/edit/GroupEditPage";
import GroupCreatePage from "../pages/group/create/GroupCreatePage";
import ProjectListPage from "../pages/project/list/ProjectListPage";
import ProjectDetailPage from "../pages/project/detail/ProjectDetailPage";
import ProjectCreatePage from "../pages/project/create/ProjectCreatePage";
import ProjectEditPage from "../pages/project/edit/ProjectEditPage";
import NotificationDetailPage from "../pages/notification/detail/NotificationDetailPage";
import SnapDetailPage from "../pages/snap/detail/SnapDetailPage";
import SnapListPage from "../pages/snap/list/SnapListPage";

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
                },
                {
                    path: "projects",
                    element: <ProjectListPage />
                },
                {
                    path: "projects/:id",
                    element: <ProjectDetailPage />
                },
                {
                    path: "projects/:id/edit",
                    element: <ProjectEditPage />
                },
                {
                    path: "projects/new",
                    element: <ProjectCreatePage />
                },
                {
                    path: "notifications",
                    element: <NotificationListPage />
                },
                {
                    path: "notifications/:id",
                    element: <NotificationDetailPage />
                },
                {
                    path: "snaps/:id",
                    element: <SnapDetailPage />
                },
                {
                    path: "snaps/chain/:id",
                    element: <SnapListPage />
                }
            ]
        },
    ]
)