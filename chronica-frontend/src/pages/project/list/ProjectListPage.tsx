import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import {TableHeader} from "../../../shared/table/TableHeader";
import Table from "../../../shared/table/Table";
import {useNavigate} from "react-router";
import ProtectedPage from "../../../shared/ProtectedPage";
import {useEffect, useState} from "react";
import axios from "axios";
import {projectsApi} from "../../../shared/apiConstants";
import {useErrorHandler} from "../../../shared/http/handleError";

function ProjectListPage() {
    const navigate = useNavigate();
    const handleError = useErrorHandler();

    const [projects, setProjects] = useState<ProjectDTO[]>([])

    useEffect(() => {
        axios.get<ProjectDTO[]>(projectsApi)
            .then(response => setProjects(response.data))
            .catch((error) => handleError(error))
    }, []);

    const headers: TableHeader<ProjectDTO>[] = [
        {
            name: "Name",
            field: "name",
            type: "string"
        },
        {
            name: "Group",
            field: "groupId",
            type: "number"
        }
    ]

    return (
        <ProtectedPage>
            <Table
                <ProjectDTO>
                objects={projects}
                headers={headers}
                onRowClick={(row) => {navigate(`${row.id}`)}}/>
        </ProtectedPage>
    )
}

export default ProjectListPage;