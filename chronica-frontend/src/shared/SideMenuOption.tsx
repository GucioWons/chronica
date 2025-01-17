import React from "react";

export interface SideMenuOptionProps {
    text: string,
    isSelected?: boolean,
    onClick: () => void,
}

function SideMenuOption(props: SideMenuOptionProps) {
    const {
        text,
        isSelected,
        onClick
    } = props;

    return (
        <div
            onClick={onClick}
            className={`side-menu-option${isSelected ? ' selected' : ''}`}
        >
            {text}
        </div>)
}

export default SideMenuOption;