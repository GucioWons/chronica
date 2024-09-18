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
            <TextField text={snap.snapActivity} label={"Activity"} horizontal/>
            <TextField text={snap.description} label={"Description"} horizontal/>
            <TextField text={snap.chainId.toString()} label={"ChainId:"} horizontal/>
            <TextField text={snap.creationDate} label={"Created:"} horizontal/>
        </Detail>
    );
}

export default SnapDetail