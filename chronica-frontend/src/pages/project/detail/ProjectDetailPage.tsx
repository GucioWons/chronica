import ProtectedPage from "../../../shared/ProtectedPage";
import ProjectDetail from "./ProjectDetail";
import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import {useEffect, useState} from "react";
import axios from "axios";
import {projectsApi} from "../../../shared/apiConstants";
import {useErrorHandler} from "../../../shared/http/handleError";

function ProjectDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [project, setProject] = useState<ProjectDTO>();
    const handleError = useErrorHandler();

    useEffect(() => {
        axios.get<ProjectDTO>(`${projectsApi}/${id}`)
            .then(data => setProject(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <ProjectDetail project={project} />
        </ProtectedPage>
    )
}

export default ProjectDetailPage;