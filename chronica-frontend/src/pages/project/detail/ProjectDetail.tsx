import Detail from "../../../shared/Detail";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import TextField from "../../../shared/TextField";

export interface ProjectDetailProps {
    project: ProjectDTO
}

function ProjectDetail(props: ProjectDetailProps) {
    const {project} = props;

    return (
        <Detail
            header={project.name}
        >
            <TextField text={project.name} label={"Name"}/>
            <TextField text={project.groupId.toString()} label={"Group"} horizontal/>
        </Detail>
    );
}

export default ProjectDetail