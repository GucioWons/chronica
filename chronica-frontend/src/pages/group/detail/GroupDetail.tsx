import {DTOs} from "../../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import TextField from "../../../shared/TextField";
import Detail from "../../../shared/Detail";
import {useAuth} from "../../../context/useAuth";
import GroupEditButton from "./GroupEditButton";

export interface GroupDetailProps {
    group?: GroupDTO
}

function GroupDetail(props: GroupDetailProps) {
    const {
        group
    } = props;

    const { account } = useAuth();

    if (!group) {
        return <div>Loading...</div>
    }

    return (
        <Detail
            header={group.name}
            button={group.ownerId === account?.id ? <GroupEditButton /> : null}
        >
            <TextField text={group.description} label={"Description"} />
            <TextField text={group.category} label={"Category"} horizontal />
        </Detail>
    );
}

export default GroupDetail;