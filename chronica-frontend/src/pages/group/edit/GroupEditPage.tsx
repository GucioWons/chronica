import {useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import GroupForm from "../form/GroupForm";
import GroupCategory = DTOs.GroupCategory;
import ProtectedPage from "../../../shared/ProtectedPage";

function GroupEditPage() {
    const { id } = useParams<{ id: string }>();

    //TODO add 404 page
    if (!id) {
        return <p>Id not found</p>;
    }

    const numericId = parseInt(id, 10);

    const group = {
        category: GroupCategory.IT,
        description: "Test_description",
        id: numericId,
        name: "TEST " + numericId,
        ownerId: 1
    }

    return (
        <ProtectedPage>
            <GroupForm group={group} />
        </ProtectedPage>
    )
}

export default GroupEditPage;