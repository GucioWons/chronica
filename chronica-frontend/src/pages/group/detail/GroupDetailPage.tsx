import ProtectedPage from "../../../shared/ProtectedPage";
import {DTOs} from "../../../shared/dto/dtos";
import GroupDetail from "./GroupDetail";
import {useNavigate, useParams} from "react-router";
import GroupDTO = DTOs.GroupDTO;
import {useEffect, useState} from "react";
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import {useErrorHandler} from "../../../shared/http/handleError";

function GroupDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [group, setGroup] = useState<GroupDTO>();
    const handleError = useErrorHandler()

    useEffect(() => {
        axios.get<GroupDTO>(`${groupsApi}/${id}`)
            .then(data => setGroup(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <GroupDetail
                group={group}
            />
        </ProtectedPage>
    )
}

export default GroupDetailPage;