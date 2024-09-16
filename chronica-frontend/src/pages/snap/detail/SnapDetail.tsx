import Detail from "../../../shared/Detail";
import {DTOs} from "../../../shared/dto/dtos";
import SnapDTO = DTOs.SnapDTO;
import TextField from "../../../shared/TextField";

export interface SnapDetailProps {
    snap?: SnapDTO
}

function SnapDetail(props: SnapDetailProps) {
    const {
        snap
    } = props;

    if (!snap) {
        return <div>Loading...</div>
    }

    return (
        <Detail
        >
            <TextField text={snap.snapActivity} label={"Activity"}/>
            <TextField text={snap.description} label={"Description"} horizontal/>
        </Detail>
    );
}

export default SnapDetail