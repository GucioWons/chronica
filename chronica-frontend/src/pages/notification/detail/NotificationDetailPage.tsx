import ProtectedPage from "../../../shared/ProtectedPage";
import NotificationDetail from "./NotificationDetail";
import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import NotificationDTO = DTOs.NotificationDTO;
import {useEffect, useState} from "react";
import axios from "axios";
import {notificationsApi} from "../../../shared/apiConstants";

function NotificationDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [notification,setNotification] = useState<NotificationDTO>();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get<NotificationDTO>(`${notificationsApi}/${id}`)
            .then(data => setNotification(data.data))
            .catch(() => navigate(-1));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <NotificationDetail notification={notification} />
        </ProtectedPage>
    )
}

export default NotificationDetailPage;