import React from "react";
import SideMenuOption from "./SideMenuOption";

export interface SideMenuProps {
    selectedSideMenuOption?: 'Projects' | 'Chains'
    setSelectedSideMenuOption: React.Dispatch<React.SetStateAction<"Projects" | "Chains" | undefined>>
}

function SideMenu(props: SideMenuProps) {
    const { selectedSideMenuOption, setSelectedSideMenuOption } = props;

    return (
        <div className="side-menu">
            <SideMenuOption
                text="Projects"
                isSelected={selectedSideMenuOption === 'Projects'}
                onClick={() => {setSelectedSideMenuOption('Projects')}}
            />
            <SideMenuOption
                text="Chains"
                isSelected={selectedSideMenuOption === 'Chains'}
                onClick={() => {setSelectedSideMenuOption('Chains')}}
            />
        </div>
    )
}

export default SideMenu;