import {useForm} from "react-hook-form";
import FormInput from "../../shared/FormInput";
import SubmitButton from "../../shared/SubmitButton";

interface LoginDTO {
    mail: string;
    password: string;
}

function LoginForm() {
    const { register, handleSubmit } = useForm<LoginDTO>();

    return (
        <div className="auth-card">
            <form>
                <FormInput
                    label={"Email"}
                    id={"mail"}
                    register={register}
                    required
                />
                <FormInput
                    label={"Password"}
                    id={"password"}
                    register={register}
                    type="password"
                    required
                />
                <SubmitButton onSubmit={ "" } text={"Sign in"} />
            </form>
        </div>
    )
}

export default LoginForm;