import ProtectedPage from "../../../shared/ProtectedPage";
import ChainForm from "../form/ChainForm";
import {useNavigate, useParams} from "react-router";
import {useCallback, useEffect, useState} from "react";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import {toast} from "react-toastify";
import {useErrorHandler} from "../../../shared/http/handleError";

function ChainEditPage() {
    const { id } = useParams<{ id: string }>();

    const [chain, setChain] = useState<ChainDTO>();

    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const handleEdition = useCallback((data: ChainDTO) => {
        axios.put<ChainDTO>(`${chainsApi}/${id}`, data)
            .then((response) => {
                toast.success("Successfully updated chain!");
                navigate("/chains/" + response.data.id);
            })
            .catch((error) => handleError(error));
    }, [id, navigate, handleError]);

    useEffect(() => {
        axios.get<ChainDTO>(`${chainsApi}/${id}`)
            .then(data => setChain(data.data))
            .catch((error) => handleError(error));
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <ProtectedPage>
            <ChainForm
                chain={chain}
                onSubmit={handleEdition}
            />
        </ProtectedPage>
    )
}

export default ChainEditPage;