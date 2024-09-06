import ProtectedRoute from "../routes/ProtectedRoute";
import React from "react";

interface ProtectedPageProps {
    children: React.ReactNode
}

function ProtectedPage(props: ProtectedPageProps) {
    return (
        <div className="protected-page">
            <ProtectedRoute>
                {props.children}
            </ProtectedRoute>
        </div>
    )
}

export default ProtectedPage;