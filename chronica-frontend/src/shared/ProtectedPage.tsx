import ProtectedRoute from "../routes/ProtectedRoute";
import React from "react";

interface ProtectedPageProps {
    children: React.ReactNode
}

function ProtectedPage(props: ProtectedPageProps) {
    return (
        <ProtectedRoute>
            {props.children}
        </ProtectedRoute>
    )
}

export default ProtectedPage;