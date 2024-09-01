import Form from "../../../shared/Form";
import {DTOs} from "../../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import FormInput from "../../../shared/FormInput";
import {useEffect, useState} from "react";
import {UseFormReturn} from "react-hook-form";

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
        </Form>
    )
}

export default GroupForm;