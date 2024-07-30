import {useAuth} from "../context/useAuth";

function Navbar() {
    const { isLoggedIn } = useAuth()

    if (!isLoggedIn()) {
        return null;
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
            }}>
                SEARCHBAR
            </div>
            <div style={{
                display: "flex",
                justifyContent: "center",
                flex: 1
            }}>
                USER
            </div>
        </div>
    )
}

export default Navbar;