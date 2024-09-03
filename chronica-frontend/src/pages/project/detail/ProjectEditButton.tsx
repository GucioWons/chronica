import {useNavigate} from "react-router";
import {useCallback} from "react";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;

export interface ProjectEditButtonProps {
    project: ProjectDTO
}

function GroupEditButton(props: ProjectEditButtonProps) {
    const { project } = props;

    const navigate = useNavigate();

    const onClick = useCallback(() => {
        navigate("edit")
    }, [project.id, navigate]);


    return (
        <button onClick={() => onClick()}>Edit</button>
    )
}

export default GroupEditButton;