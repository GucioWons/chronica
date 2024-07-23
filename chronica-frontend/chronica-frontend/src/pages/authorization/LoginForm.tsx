import React, { useCallback } from 'react';
import {useForm} from "react-hook-form";
import FormInput from "../../shared/FormInput";
import SubmitButton from "../../shared/SubmitButton";

interface LoginDTO {
    mail: string;
    password: string;
}

function LoginForm() {
    const { register, handleSubmit } = useForm<LoginDTO>();

    const onSubmit = useCallback(() => {
        console.log(register)
    }, [register]);

    return (
        <div className="auth-card" style={{marginRight: "40px"}}>
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
                <SubmitButton onSubmit={onSubmit} text={"Sign in"} />
            </form>
        </div>
    )
}

export default LoginForm;