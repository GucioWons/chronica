import {DTOs} from "../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import Form from "../../shared/form/Form";
import FormInput from "../../shared/form/FormInput";
import {useCallback, useState} from "react";
import {UseFormReturn} from "react-hook-form";
import axios from "axios";
import {projectsApi} from "../../shared/apiConstants";
import {toast} from "react-toastify";
import {useNavigate} from "react-router";

export interface ProjectFormProps {
    project?: ProjectDTO
}

function ProjectForm(props: ProjectFormProps) {
    const {project} = props;

    const editMode: boolean = !!project;

    const navigate = useNavigate();

    const [ _formMethods, setFormMethods ] = useState<UseFormReturn<ProjectDTO> | null>(null);

    const onSubmit = (data: ProjectDTO) => {
        if (editMode) {
            handleCreation(data);
        } else {
            handleEdition(data);
        }
    }

    const handleCreation = useCallback((data: ProjectDTO) => {
        axios.post<ProjectDTO>(projectsApi + "/projects", data)
            .then((response) => {
                toast.success("Successfully created project!");
                navigate("project/" + response.data.id);
            })
            .catch(() => toast.error("Could not create project!"));
    }, [navigate]);

    const handleEdition = useCallback((data: ProjectDTO) => {
        axios.put<ProjectDTO>(projectsApi + `/projects/${data.id}`, data)
            .then((response) => {
                toast.success("Successfully updated project!");
                navigate("project/" + response.data.id);
            })
            .catch(() => toast.error("Could not update project!"));
    }, [navigate]);

    return (
        <Form
            <ProjectDTO>
            id={`project-${editMode ? "edit" : "create"}`}
            onSubmit={onSubmit}
            setMethods={setFormMethods}
            defaultValues={project}
        >
            <FormInput
                <ProjectDTO>
                label="Name"
                field="name"
            />
        </Form>
    )
}

export default ProjectForm;