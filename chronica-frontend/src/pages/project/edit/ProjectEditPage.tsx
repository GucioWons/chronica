import ProjectForm from "../ProjectForm";
import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import ProtectedPage from "../../../shared/ProtectedPage";
import {useCallback, useEffect, useState} from "react";
import axios from "axios";
import {projectsApi} from "../../../shared/apiConstants";
import {useErrorHandler} from "../../../shared/http/handleError";
import {toast} from "react-toastify";

function ProjectEditPage() {
    const { id } = useParams<{ id: string }>();

    const [project, setProject] = useState<ProjectDTO>();
    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const handleEdition = useCallback((data: ProjectDTO) => {
        //TODO automatically setup groupId
        axios.put<ProjectDTO>(projectsApi + `/${data.id}`, { ...data, groupId: 1 })
            .then((response) => {
                toast.success("Successfully updated project!");
                navigate(`/projects/${response.data.id}`);
            })
            .catch((error) => handleError(error));
    }, [handleError, navigate]);

    useEffect(() => {
        axios.get<ProjectDTO>(`${projectsApi}/${id}`)
            .then(data => setProject(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <ProjectForm
                project={project}
                onSubmit={handleEdition}
            />
        </ProtectedPage>
    )
}

export default ProjectEditPage;