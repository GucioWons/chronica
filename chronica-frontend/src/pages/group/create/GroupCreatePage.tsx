import GroupForm from "../form/GroupForm";
import ProtectedPage from "../../../shared/ProtectedPage";

function GroupCreatePage() {
    return (
        <ProtectedPage>
            <GroupForm />
        </ProtectedPage>
    )
}

export default GroupCreatePage;