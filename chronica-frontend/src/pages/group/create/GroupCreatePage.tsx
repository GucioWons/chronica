import GroupForm from "../form/GroupForm";
import ProtectedPage from "../../../shared/ProtectedPage";
import {useCallback} from "react";
import axios from "axios";
import {groupsApi} from "../../../shared/apiConstants";
import {toast} from "react-toastify";
import {DTOs} from "../../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import {useNavigate} from "react-router";
import {useErrorHandler} from "../../../shared/http/handleError";

function GroupCreatePage() {
    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const handleCreation = useCallback((data: GroupDTO) => {
        axios.post<GroupDTO>(groupsApi, data)
            .then((response) => {
                toast.success("Successfully created group!");
                navigate("/groups/" + response.data.id);
            })
            .catch((error) => handleError(error));
    }, [handleError, navigate]);

    return (
        <ProtectedPage>
            <GroupForm
                onSubmit={handleCreation}
            />
        </ProtectedPage>
    )
}

export default GroupCreatePage;