import Form from "../../../shared/form/Form";
import {DTOs} from "../../../shared/dto/dtos";
import FormInput from "../../../shared/form/FormInput";
import {useCallback, useState} from "react";
import {UseFormReturn} from "react-hook-form";
import FormSelect from "../../../shared/form/FormSelect";
import GroupDTO = DTOs.GroupDTO;
import Category = DTOs.Category;
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import {useNavigate} from "react-router";
import { toast } from "react-toastify";

export interface GroupFormProps {
    group?: GroupDTO
}

function GroupForm(props: GroupFormProps) {
    const { group } = props;

    const editMode: boolean = !!group;

    const navigate = useNavigate();

    const [ formMethods, setFormMethods ] = useState<UseFormReturn<GroupDTO> | null>(null);

    const onSubmit = (data: GroupDTO) => {
        if (editMode) {
            handleCreation(data);
        } else {
            handleEdition(data);
        }
    }

    const handleCreation = useCallback((data: GroupDTO) => {
        axios.post<GroupDTO>(groupsApi + "/groups", data)
            .then((response) => {
                toast.success("Successfully created group!");
                navigate("group/" + response.data.id);
            })
            .catch(() => toast.error("Could not create group!"));
    }, []);

    const handleEdition = useCallback((data: GroupDTO) => {
        axios.put<GroupDTO>(groupsApi + `/groups/${data.id}`, data)
            .then((response) => {
                toast.success("Successfully updated group!");
                navigate("group/" + response.data.id);
            })
            .catch(() => toast.error("Could not update group!"));
    }, []);

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