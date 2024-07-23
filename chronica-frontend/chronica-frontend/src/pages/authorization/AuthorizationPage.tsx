import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";

function AuthorizationPage() {
    return (
        <div className="half-split-page">
            <LoginForm />
            <RegisterForm />
        </div>
    )
}

export default AuthorizationPage;