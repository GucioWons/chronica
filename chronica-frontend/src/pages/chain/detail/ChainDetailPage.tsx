import {useNavigate, useParams} from "react-router";
import {useEffect, useState} from "react";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import ProtectedPage from "../../../shared/ProtectedPage";
import ChainDetail from "./ChainDetail";

function ChainDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [chain, setChain] = useState<ChainDTO>();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get<ChainDTO>(`${chainsApi}/${id}`)
            .then(data => setChain(data.data))
            .catch(() => navigate(-1));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <ChainDetail chain={chain} />
        </ProtectedPage>
    )
}

export default ChainDetailPage;