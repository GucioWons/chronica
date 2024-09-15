import {useState} from "react";
import {useForm, UseFormReturn} from "react-hook-form";
import FormInput from "../../shared/form/FormInput";
import {useAuth} from "../../context/useAuth";
import Form from "../../shared/form/Form";
import {DTOs} from "../../shared/dto/dtos";
import AccountDTO = DTOs.AccountDTO;

function RegisterForm() {
    const form = useForm<AccountDTO>()

    const { registerUser } = useAuth();

    return (
        <div className="auth-card" style={{marginLeft: "40px"}}>
            <Form
                <AccountDTO>
                id="register"
                onSubmit={(data) => registerUser(data)}
                form={form}
            >
                <FormInput
                    <AccountDTO>
                    label="Username" 
                    field="username"
                    required
                />
                <FormInput
                    <AccountDTO>
                    label="Mail" 
                    field="mail"
                    required
                />
                <FormInput
                    <AccountDTO>
                    label="Phone number"
                    field="phoneNumber"
                    required
                    type="number"
                />
                <FormInput
                    <AccountDTO>
                    label="Password"
                    field="password"
                    required
                    type="password"
                />
                <FormInput
                    <AccountDTO>
                    label="Name"
                    field="person.name"
                    required
                />
                <FormInput
                    <AccountDTO>
                    label="Last name"
                    field="person.lastName"
                    required
                />
            </Form>
        </div>
    )
}

export default RegisterForm;