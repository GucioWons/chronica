import React from 'react';
import {useForm} from "react-hook-form";
import FormInput from "../../shared/form/FormInput";
import {useAuth} from "../../context/useAuth";
import Form from "../../shared/form/Form";
import {DTOs} from "../../shared/dto/dtos";
import SignInDTO = DTOs.SignInDTO;

function LoginForm() {
    const form = useForm<SignInDTO>()

    const { loginUser } = useAuth();

    return (
        <div className="auth-card" style={{marginRight: "40px"}}>
            <Form
                <SignInDTO>
                id="login"
                onSubmit={(data) => loginUser(data)}
                form={form}
            >
                <FormInput
                    <SignInDTO>
                    label="Email"
                    field="mail"
                    required
                />
                <FormInput
                    <SignInDTO>
                    label="Password"
                    field="password"
                    type="password"
                    required
                />
            </Form>
        </div>
    )
}

export default LoginForm;