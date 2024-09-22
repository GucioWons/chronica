import ProtectedPage from "../../../shared/ProtectedPage";
import SnapDetail from "./SnapDetail";
import {useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import {useEffect, useState} from "react";
import axios from "axios";
import {snapsApi} from "../../../shared/apiConstants";
import {useErrorHandler} from "../../../shared/http/handleError";
import SnapDTO = DTOs.SnapDTO;

function SnapDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [snap, setSnap] = useState<SnapDTO>();
    const handleError = useErrorHandler();

    useEffect(() => {
        axios.get<SnapDTO>(`${snapsApi}/${id}`)
            .then(data => setSnap(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <SnapDetail snap={snap} />
        </ProtectedPage>
    )
}

export default SnapDetailPage;