import Navbar from "./Navbar";
import React, {useCallback, useState} from "react";
import SideMenu from "./SideMenu";

export interface FrameProps {
    sideMenuOption?: 'Projects' | 'Chains',
    sideMenuEnabled: boolean,
    setSideMenuEnabled: React.Dispatch<React.SetStateAction<boolean>>
}

function Frame(props: FrameProps) {
    const {
        sideMenuOption,
        sideMenuEnabled,
        setSideMenuEnabled,
    } = props;

    const invertSideMenuEnabled = useCallback(() => {
        setSideMenuEnabled(!sideMenuEnabled);
    }, [setSideMenuEnabled, sideMenuEnabled]);

    const [selectedSideMenuOption, setSelectedSideMenuOption] = useState<'Projects' | 'Chains' | undefined>(sideMenuOption)

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