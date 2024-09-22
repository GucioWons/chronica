import ProtectedPage from "../../../shared/ProtectedPage";
import ChainForm from "../form/ChainForm";
import {useCallback} from "react";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import {toast} from "react-toastify";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import {useNavigate} from "react-router";
import {useErrorHandler} from "../../../shared/http/handleError";

function ChainCreatePage() {
    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const handleCreation = useCallback((data: ChainDTO) => {
        axios.post<ChainDTO>(chainsApi, data)
            .then((response) => {
                toast.success("Successfully created chain!");
                navigate("/chains/" + response.data.id);
            })
            .catch((error) => handleError(error));
    }, [navigate, handleError]);

    return (
        <ProtectedPage>
            <ChainForm
                onSubmit={handleCreation}
            />
        </ProtectedPage>
    )
}

export default ChainCreatePage;