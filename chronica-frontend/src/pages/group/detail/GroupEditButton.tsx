import {useAuth} from "../../../context/useAuth";
import {DTOs} from "../../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import {useCallback} from "react";
import {useNavigate} from "react-router";

export interface GroupEditButtonProps {
    group: GroupDTO
}

function GroupEditButton(props: GroupEditButtonProps) {
    const { group } = props;

    const navigate = useNavigate();

    const onClick = useCallback(() => {
        navigate("/group/" + group.id + "/edit")
    }, [group.id, navigate]);


    return (
        <button onClick={() => onClick()}>Edit</button>
    )
}

export default GroupEditButton;