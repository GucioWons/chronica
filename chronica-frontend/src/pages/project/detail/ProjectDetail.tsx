import Detail from "../../../shared/Detail";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import TextField from "../../../shared/TextField";
import Button from "../../../shared/Button";
import {useNavigate} from "react-router";
import {useCallback} from "react";

export interface ProjectDetailProps {
    project?: ProjectDTO
}

function ProjectDetail(props: ProjectDetailProps) {
    const {
        project
    } = props;

    const navigate = useNavigate();

    const editProject = useCallback(() => {
        navigate("edit")
    }, [navigate]);

    if (!project) {
        return <div>Loading...</div>
    }

    return (
        <Detail
            header={project.name}
            button={
                <Button
                    text="Edit"
                    outlined
                    onClick={editProject}
                />
            }
        >
            <TextField text={project.name} label={"Name"}/>
            <TextField text={project.groupId.toString()} label={"Group"} horizontal/>
        </Detail>
    );
}

export default ProjectDetail