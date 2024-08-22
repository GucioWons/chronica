import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import Divider from "../../shared/Divider";

function AuthorizationPage() {
    return (
        <Divider
            direction="horizontal"
            leftOrTopContent={<LoginForm />}
            rightOrBottomContent={<RegisterForm />}
            style={{
                marginTop: "80px",
                marginLeft: "120px",
                marginRight: "120px",
            }}
        />
    )
}

export default AuthorizationPage;