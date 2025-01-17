import ProtectedRoute from "../routes/ProtectedRoute";
import React, {useState} from "react";
import Frame from "./Frame";

interface ProtectedPageProps {
    children: React.ReactNode
    sideMenuOption?: 'Projects' | 'Chains'
}

function ProtectedPage(props: ProtectedPageProps) {
    const { children, sideMenuOption } = props;

    const [sideMenuEnabled, setSideMenuEnabled] = useState<boolean>(true)

    return (
        <div className="protected-page">
            <ProtectedRoute>
                <Frame
                    sideMenuOption={sideMenuOption}
                    sideMenuEnabled={sideMenuEnabled}
                    setSideMenuEnabled={setSideMenuEnabled}
                />
                <div className={`protected-page content${sideMenuEnabled ? '' : ' full'}`}>
                    {children}
                </div>
            </ProtectedRoute>
        </div>
    )
}

export default ProtectedPage;