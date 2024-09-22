import Form from "../../../shared/form/Form";
import {DTOs} from "../../../shared/dto/dtos";
import FormInput from "../../../shared/form/FormInput";
import {useCallback, useState} from "react";
import {useForm, UseFormReturn} from "react-hook-form";
import FormSelect from "../../../shared/form/FormSelect";
import GroupDTO = DTOs.GroupDTO;
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import {useNavigate} from "react-router";
import { toast } from "react-toastify";
import GroupCategory = DTOs.GroupCategory;
import {useErrorHandler} from "../../../shared/http/handleError";

export interface GroupFormProps {
    group?: GroupDTO
}

function GroupForm(props: GroupFormProps) {
    const { group } = props;

    const editMode: boolean = !!group;

    const navigate = useNavigate();

    const form = useForm<GroupDTO>()

    const onSubmit = (data: GroupDTO) => {
        if (editMode) {
            handleEdition(data);
        } else {
            handleCreation(data);
        }
    }

    const handleError = useErrorHandler();

    const handleCreation = useCallback((data: GroupDTO) => {
        axios.post<GroupDTO>(groupsApi, data)
            .then((response) => {
                toast.success("Successfully created group!");
                navigate("/groups/" + response.data.id);
            })
            .catch((error) => handleError(error));
    }, [handleError, navigate]);

    const handleEdition = useCallback((data: GroupDTO) => {
        axios.put<GroupDTO>(groupsApi + `/${data.id}`, data)
            .then((response) => {
                toast.success("Successfully updated group!");
                navigate("/groups/" + response.data.id);
            })
            .catch((error) => handleError(error));
    }, [navigate]);

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