import {useParams} from "react-router";
import {DTOs} from "../../../shared/dto/dtos";
import Category = DTOs.Category;
import GroupForm from "../form/GroupForm";

function GroupEditPage() {
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
        <div className="edit-page">
            <GroupForm group={group} />
        </div>
    )
}

export default GroupEditPage;