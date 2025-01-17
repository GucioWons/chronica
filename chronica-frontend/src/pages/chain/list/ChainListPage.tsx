import {useNavigate} from "react-router";
import {useEffect, useState} from "react";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import { TableHeader } from "../../../shared/table/TableHeader";
import ProtectedPage from "../../../shared/ProtectedPage";
import Table from "../../../shared/table/Table";
import {useErrorHandler} from "../../../shared/http/handleError";

function ChainListPage() {
    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const [chains, setChains] = useState<ChainDTO[]>([])

    useEffect(() => {
        axios.get<ChainDTO[]>(chainsApi)
            .then(response => setChains(response.data))
            .catch((error) => handleError(error))
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    const headers: TableHeader<ChainDTO>[] = [
        {
            name: "Title",
            field: "title",
            type: "string"
        },
        {
            name: "Estimation",
            field: "estimation",
            type: "number"
        },
        {
            name: "Time left",
            field: "timeLeft",
            type: "number"
        },
        {
            name: "Points",
            field: "points",
            type: "number"
        }
    ];

    return (
        <ProtectedPage
            sideMenuOption='Chains'
        >
            <Table
                <ChainDTO>
                objects={chains}
                headers={headers}
                onRowClick={(row) => {navigate(`${row.id}`)}}/>
        </ProtectedPage>
    )
}

export default ChainListPage;