import ProtectedPage from "../../../shared/ProtectedPage";
import ProjectDetail from "./ProjectDetail";
import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import {useEffect, useState} from "react";
import axios from "axios";
import {projectsApi} from "../../../shared/apiConstants";

function ProjectDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [project, setProject] = useState<ProjectDTO>();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get<ProjectDTO>(`${projectsApi}/${id}`)
            .then(data => setProject(data.data))
            .catch(() => navigate(-1));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <ProjectDetail project={project} />
        </ProtectedPage>
    )
}

export default ProjectDetailPage;