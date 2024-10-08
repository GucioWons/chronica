import Detail from "../../../shared/Detail";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import TextField from "../../../shared/TextField";
import ProjectEditButton from "./ProjectEditButton";

export interface ProjectDetailProps {
    project?: ProjectDTO
}

function ProjectDetail(props: ProjectDetailProps) {
    const {
        project
    } = props;

    if (!project) {
        return <div>Loading...</div>
    }

    return (
        <Detail
            header={project.name}
            button={<ProjectEditButton />}
        >
            <TextField text={project.name} label={"Name"}/>
            <TextField text={project.groupId.toString()} label={"Group"} horizontal/>
        </Detail>
    );
}

export default ProjectDetail