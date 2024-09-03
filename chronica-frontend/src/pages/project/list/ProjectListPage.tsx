import {DTOs} from "../../../shared/dto/dtos";
import ProjectDTO = DTOs.ProjectDTO;
import {TableHeader} from "../../../shared/table/TableHeader";
import Table from "../../../shared/table/Table";

function ProjectListPage() {
    const objects: ProjectDTO[] = [
        {
            id: 1,
            createdDate: "",
            deprecated: false,
            groupId: 1,
            lastChangeDate: "",
            name: "name 1"
        },
        {
            id: 1,
            createdDate: "",
            deprecated: false,
            groupId: 1,
            lastChangeDate: "",
            name: "name 1"
        },
        {
            id: 1,
            createdDate: "",
            deprecated: false,
            groupId: 1,
            lastChangeDate: "",
            name: "name 1"
        },
        {
            id: 1,
            createdDate: "",
            deprecated: false,
            groupId: 1,
            lastChangeDate: "",
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
        <div className="list-page">
            <Table
                <ProjectDTO>
                objects={objects}
                headers={headers}
                onRowClick={(row) => {console.log(row)}}/>
        </div>
    )
}

export default ProjectListPage;