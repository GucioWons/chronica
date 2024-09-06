import {useNavigate} from "react-router";
import {useCallback} from "react";

function GroupEditButton() {
    const navigate = useNavigate();

    const onClick = useCallback(() => {
        navigate("edit")
    }, [navigate]);

    return (
        <button onClick={() => onClick()}>Edit</button>
    )
}

export default GroupEditButton;