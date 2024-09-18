import ProtectedPage from "../../../shared/ProtectedPage";
import ChainForm from "../form/ChainForm";
import {useCallback} from "react";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import {toast} from "react-toastify";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import {useNavigate} from "react-router";

function ChainCreatePage() {
    const navigate = useNavigate();

    const handleCreation = useCallback((data: ChainDTO) => {
        axios.post<ChainDTO>(chainsApi, data)
            .then((response) => {
                toast.success("Successfully created chain!");
                navigate("/chains/" + response.data.id);
            })
            .catch(() => toast.error("Could not create chain!"));
    }, [navigate]);

    return (
        <ProtectedPage>
            <ChainForm
                onSubmit={handleCreation}
            />
        </ProtectedPage>
    )
}

export default ChainCreatePage;