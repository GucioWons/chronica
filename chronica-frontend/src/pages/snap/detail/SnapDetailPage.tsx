import ProtectedPage from "../../../shared/ProtectedPage";
import SnapDetail from "./SnapDetail";
import {useNavigate, useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import SnapDTO = DTOs.SnapDTO;
import {useEffect, useState} from "react";
import axios from "axios";
import {snapsApi} from "../../../shared/apiConstants";

function SnapDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [snap, setSnap] = useState<SnapDTO>();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get<SnapDTO>(`${snapsApi}/${id}`)
            .then(data => setSnap(data.data))
            .catch(() => navigate(-1));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <SnapDetail snap={snap} />
        </ProtectedPage>
    )
}

export default SnapDetailPage;