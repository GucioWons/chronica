import React, {useEffect, useState} from "react";
import axios from "axios";
import {usersApi} from "../../shared/apiConstants";
import {useParams} from "react-router";

function ConfirmationPage(){
    const { confirmation } = useParams<{ confirmation: string }>();

    const [confirmationResult, setConfirmationResult] = useState<boolean | null>(null);

    useEffect(() => {
        if (confirmation) {
            axios.get(usersApi + "/links/confirmation/" + confirmation)
                .then(() => setConfirmationResult(true))
                .catch(() => setConfirmationResult(false));
        }
    }, [confirmation]);

    return (
        <div>
            {confirmationResult === null && <p>Sprawdzanie potwierdzenia...</p>}
            {confirmationResult === true && <p>Potwierdzenie zakończone sukcesem!</p>}
            {confirmationResult === false && <p>Potwierdzenie nie powiodło się.</p>}
        </div>
    )
}

export default ConfirmationPage