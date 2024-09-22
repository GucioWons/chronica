import {DTOs} from "../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import Form from "../../shared/form/Form";
import FormInput from "../../shared/form/FormInput";
import {useCallback, useState} from "react";
import {useForm, UseFormReturn} from "react-hook-form";
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

    const form = useForm<ProjectDTO>();

    const onSubmit = (data: ProjectDTO) => {
        if (editMode) {
            handleEdition(data);
        } else {
            handleCreation(data);
        }
    }

    const handleCreation = useCallback((data: ProjectDTO) => {
        //TODO automatically setup groupId
        axios.post<ProjectDTO>(projectsApi, { ...data, groupId: 1 })
            .then((response) => {
                toast.success("Successfully created project!");
                navigate(`/projects/${response.data.id}`);
            })
            .catch(() => toast.error("Could not create project!"));
    }, [navigate]);

    const handleEdition = useCallback((data: ProjectDTO) => {
        //TODO automatically setup groupId
        axios.put<ProjectDTO>(projectsApi + `/${data.id}`, { ...data, groupId: 1 })
            .then((response) => {
                toast.success("Successfully updated project!");
                navigate(`/projects/${response.data.id}`);
            })
            .catch(() => toast.error("Could not update project!"));
    }, [navigate]);

    return (
        <Form
            <ProjectDTO>
            id={`project-${editMode ? "edit" : "create"}`}
            onSubmit={onSubmit}
            form={form}
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