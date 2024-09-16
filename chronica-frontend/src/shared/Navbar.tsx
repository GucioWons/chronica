import {useAuth} from "../context/useAuth";
import { useNavigate } from "react-router-dom";

function Navbar() {
    const { isLoggedIn, account, logoutUser } = useAuth()
    const navigate = useNavigate();

    if (!isLoggedIn()) {
        return null;
    }

    const handleNotificaitons = () => {
        navigate("/notifications", {replace:true});
    }

    return (
        <div className="navbar">
            <div style={{
                display: "flex",
                justifyContent: "flex-start",
                flex: 2
            }}>
                MENU
            </div>
            <div style={{
                display: "flex",
                justifyContent: "center",
                flex: 1
            }}>
                CHRONICA
            </div>
            <div style={{
                display: "flex",
                justifyContent: "center",
                flex: 1
            }}
            onClick={handleNotificaitons}
            >
                NOTIFICATIONS
            </div>
            <div style={{
                display: "flex",
                justifyContent: "center",
                flex: 1
            }}>
                <input/>
            </div>
            <div style={{
                display: "flex",
                justifyContent: "center",
                flex: 1
            }}>
                {account?.username}
                <button onClick={logoutUser}>logout</button>
            </div>
        </div>
    )
}

export default Navbar;