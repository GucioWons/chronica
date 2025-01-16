import {DTOs} from "../../shared/dto/dtos";
import Form from "../../shared/form/Form";
import FormInput from "../../shared/form/FormInput";
import {useForm} from "react-hook-form";
import ProjectDTO = DTOs.ProjectDTO;

export interface ProjectFormProps {
    project?: ProjectDTO,
    onSubmit: (data: ProjectDTO) => void
}

function ProjectForm(props: ProjectFormProps) {
    const {
        project,
        onSubmit
    } = props;

    const editMode: boolean = !!project;

    const form = useForm<ProjectDTO>();

    return (
        <Form
            <ProjectDTO>
            id={`project-${editMode ? "edit" : "create"}`}
            title={editMode ? "Edit Project" : "Create new project"}
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