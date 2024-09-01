import {DTOs} from "../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import TextField from "../../shared/TextField";
import Detail from "../../shared/Detail";

export interface GroupDetailProps {
    group: GroupDTO
}

function GroupDetail(props: GroupDetailProps) {
    const {group} = props;

    return (
        <Detail header={group.name}>
            <TextField text={group.description} label={"Description"} />
            <TextField text={group.category} label={"Category"} horizontal />
        </Detail>
    );
}

export default GroupDetail;