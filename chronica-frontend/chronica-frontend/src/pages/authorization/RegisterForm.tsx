import { useCallback } from "react";
import {useForm} from "react-hook-form";
import FormInput from "../../shared/FormInput";
import SubmitButton from "../../shared/SubmitButton";

interface PersonDTO {
    name: string,
    lastName: string,
    age: number,
}

interface RegisterDTO {
    username: string,
    mail: string,
    phoneNumber: number,
    password: string,
    person: PersonDTO,
}

function RegisterForm() {
    const { register, handleSubmit } = useForm<RegisterDTO>();

    const onSubmit = useCallback(() => {
        console.log(register)
    }, [register]);

    return (
        <div className="auth-card" style={{marginLeft: "40px"}}>
            <form>
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
                <SubmitButton onSubmit={onSubmit} text={"Sign up"} />
            </form>
        </div>
    )
}

export default RegisterForm;