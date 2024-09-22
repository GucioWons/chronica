import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import GroupForm from "../form/GroupForm";

import ProtectedPage from "../../../shared/ProtectedPage";
import {useCallback, useEffect, useState} from "react";
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import GroupDTO = DTOs.GroupDTO;
import {useErrorHandler} from "../../../shared/http/handleError";
import {toast} from "react-toastify";

function GroupEditPage() {
    const { id } = useParams<{ id: string }>();

    const [group, setGroup] = useState<GroupDTO>();

    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const handleEdition = useCallback((data: GroupDTO) => {
        axios.put<GroupDTO>(groupsApi + `/${data.id}`, data)
            .then((response) => {
                toast.success("Successfully updated group!");
                navigate("/groups/" + response.data.id);
            })
            .catch((error) => handleError(error));
    }, [navigate, handleError]);

    useEffect(() => {
        axios.get<GroupDTO>(`${groupsApi}/${id}`)
            .then(data => setGroup(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <GroupForm
                group={group}
                onSubmit={handleEdition}
            />
        </ProtectedPage>
    )
}

export default GroupEditPage;