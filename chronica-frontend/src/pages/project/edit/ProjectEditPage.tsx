import ProjectForm from "../ProjectForm";
import {useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import ProtectedPage from "../../../shared/ProtectedPage";

function ProjectEditPage() {
    const { id } = useParams<{ id: string }>();

    //TODO add 404 page
    if (!id) {
        return <p>Id not found</p>;
    }

    const numericId = parseInt(id, 10);

    const project: ProjectDTO = {
        groupId: 1,
        id: numericId,
        name: `Project ${numericId}`
    }

    return (
        <ProtectedPage>
            <ProjectForm project={project} />
        </ProtectedPage>
    )
}

export default ProjectEditPage;