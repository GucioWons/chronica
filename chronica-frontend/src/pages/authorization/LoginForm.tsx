import React, {useState} from 'react';
import {UseFormReturn} from "react-hook-form";
import FormInput from "../../shared/FormInput";
import {SignInDTO, useAuth} from "../../context/useAuth";
import Form from "../../shared/Form";

function LoginForm() {
    const [ _formMethods, setFormMethods ] = useState<UseFormReturn<SignInDTO> | null>(null);

    const { loginUser } = useAuth();

    const onSubmit = (data: SignInDTO) => {
        loginUser(data);
    }

    return (
        <div className="auth-card" style={{marginRight: "40px"}}>
            <Form
                <SignInDTO>
                id="login"
                onSubmit={onSubmit}
                setMethods={setFormMethods}
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