import {useAuth} from "../context/useAuth";
import { useNavigate } from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faBars, faBell, faRightFromBracket} from "@fortawesome/free-solid-svg-icons";

export interface NavbarProps {
    invertSideMenuEnabled: () => void;
}

function Navbar(props: NavbarProps) {
    const { invertSideMenuEnabled } = props;

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
                flex: 1
            }}>
                <FontAwesomeIcon onClick={invertSideMenuEnabled} icon={faBars} />
            </div>
            <div style={{
                display: "flex",
                justifyContent: "center",
                flex: 2
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
                <FontAwesomeIcon icon={faBell} />
            </div>
            <div className="input-input" style={{
                display: "flex",
                justifyContent: "center",
                flex: 1
            }}>
                <input placeholder="Search"/>
            </div>
            <div style={{
                display: "flex",
                justifyContent: "space-around",
                flex: 1
            }}>
                <div>
                    {account?.username}
                </div>
                <div>
                    <FontAwesomeIcon onClick={logoutUser} icon={faRightFromBracket} />
                </div>
            </div>
        </div>
    )
}

export default Navbar;