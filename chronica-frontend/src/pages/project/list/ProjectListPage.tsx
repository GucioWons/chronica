import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import {TableHeader} from "../../../shared/table/TableHeader";
import Table from "../../../shared/table/Table";
import {useNavigate} from "react-router";
import ProtectedPage from "../../../shared/ProtectedPage";

function ProjectListPage() {
    const navigate = useNavigate();

    const objects: ProjectDTO[] = [
        {
            id: 1,
            groupId: 1,
            name: "name 1"
        },
        {
            id: 1,
            groupId: 1,
            name: "name 1"
        },
        {
            id: 1,
            groupId: 1,
            name: "name 1"
        },
        {
            id: 1,
            groupId: 1,
            name: "name 1"
        },
    ];

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
                objects={objects}
                headers={headers}
                onRowClick={(row) => {navigate(`${row.id}`)}}/>
        </ProtectedPage>
    )
}

export default ProjectListPage;