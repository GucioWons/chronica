import './App.css';
import {Outlet} from "react-router";
import {UserProvider} from "./context/useAuth";

function App() {
    return (
        <>
            <UserProvider>
                <Outlet/>
            </UserProvider>
        </>
    );
}

export default App;
