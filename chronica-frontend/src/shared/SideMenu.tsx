import React, {useCallback, useState} from "react";
import {SideMenuOptionType} from "./SideMenuOptionType";
import SideMenuOption from "./SideMenuOption";
import {useNavigate} from "react-router";

export interface SideMenuProps {
    selectedSideMenuOption?: SideMenuOptionType
    setSelectedSideMenuOption: React.Dispatch<React.SetStateAction<SideMenuOptionType | undefined>>
}

function SideMenu(props: SideMenuProps) {
    const { selectedSideMenuOption, setSelectedSideMenuOption } = props;

    const navigate = useNavigate();

    const updateSelectedSideMenuOption = useCallback((sideMenuOption: SideMenuOptionType) => {
        if (sideMenuOption === selectedSideMenuOption) {
            setSelectedSideMenuOption(undefined);
        } else {
            setSelectedSideMenuOption(sideMenuOption);
        }
    }, [selectedSideMenuOption, setSelectedSideMenuOption]);

    return (
        <div className="side-menu-container">
            <div className="side-menu">
                {Object.entries(SideMenuOptionType).map(([key, option]) => (
                    <SideMenuOption
                        key={key}
                        text={option.id}
                        isSelected={selectedSideMenuOption === key}
                        onClick={() => updateSelectedSideMenuOption(key as SideMenuOptionType)}
                    />
                ))}
            </div>
            {selectedSideMenuOption &&
                <div className="side-menu">
                    {SideMenuOptionType[selectedSideMenuOption].subMenuOptions.map((subMenuItem, index) => (
                        <div
                            className={`side-menu-option`}
                            key={index}
                            onClick={() => navigate(subMenuItem.path)}
                        >
                            {subMenuItem.label}
                        </div>
                    ))}
                </div>
            }
        </div>
    )
}

export default SideMenu;