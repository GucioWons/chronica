import './App.css';
import {Outlet} from "react-router";
import {UserProvider} from "./context/useAuth";
import Navbar from "./shared/Navbar";

function App() {
    return (
        <>
            <UserProvider>
                <Navbar />
                <Outlet />
            </UserProvider>
        </>
    );
}

export default App;
