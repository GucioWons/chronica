import { useCallback } from "react";
import {SubmitHandler, useForm} from "react-hook-form";
import FormInput from "../../shared/FormInput";
import SubmitButton from "../../shared/SubmitButton";
import {AccountDTO, useAuth} from "../../context/useAuth";

function RegisterForm() {
    const { register, handleSubmit } = useForm<AccountDTO>();

    const { registerUser } = useAuth();

    const onSubmit: SubmitHandler<AccountDTO> = ((data, event) => {
        event?.preventDefault();
        registerUser(data);
    });

    return (
        <div className="auth-card" style={{marginLeft: "40px"}}>
            <form onSubmit={handleSubmit(onSubmit)}>
                <FormInput 
                    label="Username" 
                    id="username" 
                    register={register} 
                    required
                />
                <FormInput 
                    label="Mail" 
                    id="mail" 
                    register={register}
                    required
                />
                <FormInput
                    label="Phone number"
                    id="phoneNumber"
                    register={register}
                    required
                    type="number"
                />
                <FormInput
                    label="Password"
                    id="password"
                    register={register}
                    required
                    type="password"
                />
                <FormInput
                    label="Name"
                    id="person.name"
                    register={register}
                    required
                />
                <FormInput
                    label="Last name"
                    id="person.lastName"
                    register={register}
                    required
                />
                <FormInput
                    label="Age"
                    id="person.age"
                    register={register}
                    required
                    type="number"
                />
                <SubmitButton text={"Sign up"} />
            </form>
        </div>
    )
}

export default RegisterForm;