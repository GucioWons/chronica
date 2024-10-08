import {useParams} from "react-router";
import {useEffect, useState} from "react";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import {DTOs} from "../../../shared/dto/dtos";
import ProtectedPage from "../../../shared/ProtectedPage";
import ChainDetail from "./ChainDetail";
import {useErrorHandler} from "../../../shared/http/handleError";
import ChainDTO = DTOs.ChainDTO;

function ChainDetailPage() {
    const { id } = useParams<{ id: string }>();

    const [chain, setChain] = useState<ChainDTO>();
    const handleError = useErrorHandler();

    useEffect(() => {
        axios.get<ChainDTO>(`${chainsApi}/${id}`)
            .then(data => setChain(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <ChainDetail chain={chain} />
        </ProtectedPage>
    )
}

export default ChainDetailPage;