import Form from "../../../shared/form/Form";
import {DTOs} from "../../../shared/dto/dtos";
import FormInput from "../../../shared/form/FormInput";
import {useState} from "react";
import {UseFormReturn} from "react-hook-form";
import FormSelect from "../../../shared/form/FormSelect";
import GroupDTO = DTOs.GroupDTO;
import Category = DTOs.Category;

export interface GroupFormProps {
    group?: GroupDTO
}

function GroupForm(props: GroupFormProps) {
    const { group } = props;

    const [ formMethods, setFormMethods ] = useState<UseFormReturn<GroupDTO> | null>(null);

    const onSubmit = (data: GroupDTO) => {
        console.log(data);
    }

    return (
        <Form
            <GroupDTO>
            id="group-edit"
            onSubmit={onSubmit}
            setMethods={setFormMethods}
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
                <GroupDTO, Category>
                setValue={formMethods?.setValue}
                field="category"
                label="Category"
                options={Object.values(Category)}
            />
        </Form>
    )
}

export default GroupForm;