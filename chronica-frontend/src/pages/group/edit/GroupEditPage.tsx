import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import GroupForm from "../form/GroupForm";
import GroupCategory = DTOs.GroupCategory;
import ProtectedPage from "../../../shared/ProtectedPage";
import {useEffect, useState} from "react";
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import GroupDTO = DTOs.GroupDTO;

function GroupEditPage() {
    const { id } = useParams<{ id: string }>();

    const [group, setGroup] = useState<GroupDTO>();
    const [isLoading, setIsLoading] = useState<boolean>(true);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get<GroupDTO>(`${groupsApi}/${id}`)
            .then(data => {
                setGroup(data.data);
                setIsLoading(false);
            })
            .catch(() => navigate(-1));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <GroupForm group={group} />
        </ProtectedPage>
    )
}

export default GroupEditPage;