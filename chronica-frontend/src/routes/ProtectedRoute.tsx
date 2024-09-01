import React from "react";
import {Navigate, useLocation} from "react-router";
import {useAuth} from "../context/useAuth";

interface ProtectedRouteProps {
    children: React.ReactNode;
}

function ProtectedRoute(props: ProtectedRouteProps) {
    const location = useLocation();
    const { isLoggedIn } = useAuth();

    return !isLoggedIn()
        ? (<>{ props.children }</>)
        : (<Navigate to="/auth" state={{ from: location }} replace />);
}

export default ProtectedRoute;