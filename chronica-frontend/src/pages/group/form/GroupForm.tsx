import Form from "../../../shared/form/Form";
import {DTOs} from "../../../shared/dto/dtos";
import FormInput from "../../../shared/form/FormInput";
import {useForm} from "react-hook-form";
import FormSelect from "../../../shared/form/FormSelect";
import GroupDTO = DTOs.GroupDTO;
import GroupCategory = DTOs.GroupCategory;

export interface GroupFormProps {
    group?: GroupDTO
    onSubmit: (data: GroupDTO) => void
}

function GroupForm(props: GroupFormProps) {
    const {
        group,
        onSubmit
    } = props;

    const form = useForm<GroupDTO>()

    return (
        <Form
            <GroupDTO>
            id="group-edit"
            onSubmit={onSubmit}
            form={form}
            defaultValues={group}
        >
            <FormInput
                <GroupDTO>
                label="Name"
                field="name"
            />
            <FormInput
                <GroupDTO>
                label="Description"
                field="description"
            />
            <FormSelect
                <GroupDTO, GroupCategory>
                setValue={form.setValue}
                field="category"
                label="Category"
                options={Object.values(GroupCategory)}
            />
        </Form>
    )
}

export default GroupForm;