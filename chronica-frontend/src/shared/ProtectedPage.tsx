import ProtectedRoute from "../routes/ProtectedRoute";
import React from "react";
import Frame from "./Frame";

interface ProtectedPageProps {
    children: React.ReactNode
    sideMenuOption?: 'Projects' | 'Chains'
}

function ProtectedPage(props: ProtectedPageProps) {
    const { children, sideMenuOption } = props;
    return (
        <div className="protected-page">
            <ProtectedRoute>
                <Frame sideMenuOption={sideMenuOption} />
                <div className="protected-page content">
                    {children}
                </div>
            </ProtectedRoute>
        </div>
    )
}

export default ProtectedPage;