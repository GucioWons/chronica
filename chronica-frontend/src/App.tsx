import './App.css';
import {Outlet} from "react-router";
import {UserProvider} from "./context/useAuth";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

function App() {
    return (
        <>
            <UserProvider>
                <Outlet />
                <ToastContainer />
            </UserProvider>
        </>
    );
}

export default App;
