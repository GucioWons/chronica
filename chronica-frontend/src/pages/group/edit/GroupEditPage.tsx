import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import GroupForm from "../form/GroupForm";

import ProtectedPage from "../../../shared/ProtectedPage";
import {useEffect, useState} from "react";
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import GroupDTO = DTOs.GroupDTO;
import {useErrorHandler} from "../../../shared/http/handleError";

function GroupEditPage() {
    const { id } = useParams<{ id: string }>();

    const [group, setGroup] = useState<GroupDTO>();
    const handleError = useErrorHandler();

    useEffect(() => {
        axios.get<GroupDTO>(`${groupsApi}/${id}`)
            .then(data => setGroup(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <GroupForm group={group} />
        </ProtectedPage>
    )
}

export default GroupEditPage;