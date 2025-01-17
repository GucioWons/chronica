import Navbar from "./Navbar";
import React, {useState} from "react";
import SideMenu from "./SideMenu";

export interface FrameProps {
    sideMenuOption?: 'Projects' | 'Chains'
}

function Frame(props: FrameProps) {
    const { sideMenuOption } = props;

    const [selectedSideMenuOption, setSelectedSideMenuOption] = useState<'Projects' | 'Chains' | undefined>(sideMenuOption)

    return (
        <div className="frame">
            <Navbar/>
            <SideMenu
                selectedSideMenuOption={selectedSideMenuOption} 
                setSelectedSideMenuOption={setSelectedSideMenuOption}
            />
        </div>
    )
}

export default Frame;