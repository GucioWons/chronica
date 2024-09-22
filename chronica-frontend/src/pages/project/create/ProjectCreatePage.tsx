import ProjectForm from "../ProjectForm";
import ProtectedPage from "../../../shared/ProtectedPage";
import {useCallback} from "react";
import axios from "axios";
import {projectsApi} from "../../../shared/apiConstants";
import {toast} from "react-toastify";
import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import {useNavigate} from "react-router";
import {useErrorHandler} from "../../../shared/http/handleError";

function ProjectCreatePage() {
    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const handleCreation = useCallback((data: ProjectDTO) => {
        //TODO automatically setup groupId
        axios.post<ProjectDTO>(projectsApi, { ...data, groupId: 1 })
            .then((response) => {
                toast.success("Successfully created project!");
                navigate(`/projects/${response.data.id}`);
            })
            .catch((error) => handleError(error));
    }, [navigate, handleError]);

    return (
        <ProtectedPage>
            <ProjectForm
                onSubmit={handleCreation}
            />
        </ProtectedPage>
    )
}

export default ProjectCreatePage;