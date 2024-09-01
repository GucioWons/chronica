import ProtectedPage from "../../shared/ProtectedPage";
import {DTOs} from "../../shared/dto/dtos";
import GroupDetail from "./GroupDetail";
import {useParams} from "react-router";
import Category = DTOs.Category;

function GroupPage() {
    const { id } = useParams<{ id: string }>();

    //TODO add 404 page
    if (!id) {
        return <p>Id not found</p>;
    }

    const numericId = parseInt(id, 10);

    const group = {
        category: Category.IT,
        deprecated: false,
        description: "Test_description",
        id: numericId,
        name: "TEST " + numericId,
        ownerId: 1
    }

    return (
        <ProtectedPage>
            <GroupDetail group={group} />
        </ProtectedPage>
    )
}

export default GroupPage;