import {DTOs} from "../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import TextField from "../../shared/TextField";

export interface GroupDetailProps {
    group: GroupDTO
}

function GroupDetail(props: GroupDetailProps) {
    const {group} = props;

    return (
        <div>
            <TextField text={group.name} label={"Name"} />
            <TextField text={group.description} label={"Description"} />
            <TextField text={group.category} label={"Category"} />
        </div>
    );
}

export default GroupDetail;