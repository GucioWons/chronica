import ProtectedPage from "../../../shared/ProtectedPage";
import ChainForm from "../form/ChainForm";

function ChainCreatePage() {
    return (
        <ProtectedPage>
            <ChainForm />
        </ProtectedPage>
    )
}

export default ChainCreatePage;