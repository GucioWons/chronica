import {DTOs} from "../../../shared/dto/dtos";
import SnapDTO = DTOs.SnapDTO;
import {TableHeader} from "../../../shared/table/TableHeader";
import Table from "../../../shared/table/Table";
import {useNavigate, useParams} from "react-router";
import ProtectedPage from "../../../shared/ProtectedPage";
import {useEffect, useState} from "react";
import axios from "axios";
import {snapsApi} from "../../../shared/apiConstants";

function SnapListPage() {
    const navigate = useNavigate();
    const { id } = useParams<{ id: string }>();

    const [snaps,setSnaps] = useState<SnapDTO[]>([])

    useEffect(() => {
        axios.get<SnapDTO[]>(`${snapsApi}/chain/${id}`)
            .then(response => setSnaps(response.data))
            .catch(() => {})
    }, []);

    const headers: TableHeader<SnapDTO>[] = [
        {
            name: "Name",
            field: "snapActivity",
            type: "string"
        },
        {
            name: "Description",
            field: "description",
            type: "string"
        }
    ]

    return (
        <ProtectedPage>
            <Table
                <SnapDTO>
                objects={snaps}
                headers={headers}
                onRowClick={(row) => {navigate(`${row.id}`)}}/>
        </ProtectedPage>
    )
}

export default SnapListPage;