import ProtectedRoute from "../routes/ProtectedRoute";
import React, {useCallback, useState} from "react";
import Frame from "./Frame";
import {SideMenuOptionType} from "./SideMenuOptionType";

interface ProtectedPageProps {
    children: React.ReactNode,
    sideMenuOption?: SideMenuOptionType
}

function ProtectedPage(props: ProtectedPageProps) {
    const { children, sideMenuOption } = props;

    const [sideMenuEnabled, setSideMenuEnabled] = useState<boolean>(true)

    const [selectedSideMenuOption, setSelectedSideMenuOption] = useState<SideMenuOptionType | undefined>(sideMenuOption)

    const getContentSize = useCallback(() => {
        if (sideMenuEnabled && selectedSideMenuOption) {
            return 'small';
        } else if (sideMenuEnabled) {
            return 'medium';
        }
        return 'large';
    }, [selectedSideMenuOption, sideMenuEnabled]);

    const contentSize = getContentSize();

    return (
        <div className="protected-page">
            <ProtectedRoute>
                <Frame
                    selectedSideMenuOption={selectedSideMenuOption}
                    setSelectedSideMenuOption={setSelectedSideMenuOption}
                    sideMenuEnabled={sideMenuEnabled}
                    setSideMenuEnabled={setSideMenuEnabled}
                />
                <div className={`protected-page content ${contentSize}`}>
                    {children}
                </div>
            </ProtectedRoute>
        </div>
    )
}

export default ProtectedPage;