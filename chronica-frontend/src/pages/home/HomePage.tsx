import React from 'react';
import ProtectedPage from "../../shared/ProtectedPage";

function HomePage() {
    return (
        <ProtectedPage>
            <div>
                HOMEPAGEEEE
            </div>
        </ProtectedPage>
    )
}

export default HomePage;