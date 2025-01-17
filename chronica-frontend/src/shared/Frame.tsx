import Navbar from "./Navbar";
import React, {useCallback, useState} from "react";
import SideMenu from "./SideMenu";
import {SideMenuOptionType} from "./SideMenuOptionType";

export interface FrameProps {
    selectedSideMenuOption?: SideMenuOptionType,
    setSelectedSideMenuOption: React.Dispatch<React.SetStateAction<"Projects" | "Chains" | undefined>>
    sideMenuEnabled: boolean,
    setSideMenuEnabled: React.Dispatch<React.SetStateAction<boolean>>
}

function Frame(props: FrameProps) {
    const {
        selectedSideMenuOption,
        setSelectedSideMenuOption,
        sideMenuEnabled,
        setSideMenuEnabled,
    } = props;

    const invertSideMenuEnabled = useCallback(() => {
        setSideMenuEnabled(!sideMenuEnabled);
    }, [setSideMenuEnabled, sideMenuEnabled]);

    return (
        <div className="frame">
            <Navbar invertSideMenuEnabled={invertSideMenuEnabled} />
            {sideMenuEnabled &&
                <SideMenu
                    selectedSideMenuOption={selectedSideMenuOption}
                    setSelectedSideMenuOption={setSelectedSideMenuOption}
                />
            }
        </div>
    )
}

export default Frame;