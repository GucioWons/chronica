import Detail from "../../../shared/Detail";
import {DTOs} from "../../../shared/dto/dtos";
import NotificationDTO = DTOs.NotificationDTO;
import TextField from "../../../shared/TextField";

export interface NotificationDetailProps {
    notification?: NotificationDTO
}

function NotificationDetail(props: NotificationDetailProps) {
    const {
        notification
    } = props;

    if (!notification) {
        return <div>Loading...</div>
    }

    return (
        <Detail>
            <TextField text={notification.title} label={"Name"}/>
            <TextField text={notification.content.toString()} label={"Content"} horizontal/>
        </Detail>
    );
}

export default NotificationDetail