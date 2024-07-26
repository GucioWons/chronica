import React from 'react';
import {SubmitHandler, useForm} from "react-hook-form";
import FormInput from "../../shared/FormInput";
import SubmitButton from "../../shared/SubmitButton";
import {SignInDTO, useAuth} from "../../context/useAuth";

function LoginForm() {
    const { register, handleSubmit } = useForm<SignInDTO>();

    const { loginUser } = useAuth();

    const onSubmit: SubmitHandler<SignInDTO> = ((data, event) => {
        event?.preventDefault();
        loginUser(data);
    });

    return (
        <div className="auth-card" style={{marginRight: "40px"}}>
            <form onSubmit={handleSubmit(onSubmit)}>
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
                <SubmitButton text={"Sign in"} />
            </form>
        </div>
    )
}

export default LoginForm;