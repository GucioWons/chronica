import React from "react";
import { useNavigate } from "react-router-dom";

export const SideMenuOptionType = {
    Projects: {
        id: "Projects",
        subMenuOptions: [
            {
                label: "New Project",
                path: "/projects/new",
            },
            {
                label: "List",
                path: "/projects",
            }
        ]
    },
    Chains: {
        id: "Chains",
        subMenuOptions: [
            {
                label: "New Chain",
                path: "/chains/new",
            },
            {
                label: "List",
                path: "/chains",
            }
        ]
    },
} as const;

export type SideMenuOptionType = keyof typeof SideMenuOptionType;