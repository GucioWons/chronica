import {DTOs} from "../../../shared/dto/dtos";
import NotificationDTO = DTOs.NotificationDTO;
import {TableHeader} from "../../../shared/table/TableHeader";
import Table from "../../../shared/table/Table";
import {useNavigate} from "react-router";
import ProtectedPage from "../../../shared/ProtectedPage";
import {useEffect, useState} from "react";
import axios from "axios";
import {notificationsApi} from "../../../shared/apiConstants";
import {useErrorHandler} from "../../../shared/http/handleError";

function NotificationListPage() {
    const navigate = useNavigate();

    const [notifications, setNotifications] = useState<NotificationDTO[]>([])
    const [filterType, setFilterType] = useState<string>('all');
    const handleError = useErrorHandler();

    useEffect(() => {
        axios.get<NotificationDTO[]>(notificationsApi)
            .then(response => setNotifications(response.data))
            .catch((error) => handleError(error))
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    const filteredNotifications = notifications.filter(
        notification => {
            if(filterType === 'all') return true;
            return notification.type === filterType;
        }
    )

    const headers: TableHeader<NotificationDTO>[] = [
        {
            name: "Name",
            field: "title",
            type: "string"
        },
        {
            name: "Typ",
            field: "type",
            type: "string"
        },
        {
            name: "Seen",
            field: "seen",
            type: "string"
        }
    ]

    return (
        <ProtectedPage>
            <div>
                <label htmlFor="filter">Filter: </label>
                <select
                    id="filter"
                    value={filterType}
                    onChange={(e) => setFilterType(e.target.value)}
                >
                    <option value="all">All</option>
                    <option value="alert">Alert</option>
                    <option value="message">Message</option>
                    <option value="invitation">Invitation</option>
                </select>
            </div>
            <Table
                <NotificationDTO>
                objects={filteredNotifications}
                headers={headers}
                onRowClick={(row) => {
                    navigate(`${row.id}`)
                }}/>
        </ProtectedPage>
    )
}

export default NotificationListPage;