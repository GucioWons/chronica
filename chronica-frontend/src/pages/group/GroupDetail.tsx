import {DTOs} from "../../shared/dto/dtos";
import GroupDTO = DTOs.GroupDTO;
import TextField from "../../shared/TextField";

export interface GroupDetailProps {
    group: GroupDTO
}

function GroupDetail(props: GroupDetailProps) {
    const {group} = props;

    return (
        <div className="detail">
            <div className="detail-header">
                {group.name}
            </div>
            <div className="detail-content">
                <TextField text={group.description} label={"Description"} />
                <TextField text={group.category} label={"Category"} horizontal />
            </div>
        </div>
    );
}

export default GroupDetail;