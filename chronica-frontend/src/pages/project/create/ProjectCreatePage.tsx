import ProjectForm from "../ProjectForm";
import ProtectedPage from "../../../shared/ProtectedPage";

function ProjectCreatePage() {
    return (
        <ProtectedPage>
            <ProjectForm />
        </ProtectedPage>
    )
}

export default ProjectCreatePage;