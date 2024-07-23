import {UseFormRegister} from "react-hook-form";

interface FormInputProps {
    horizontal?: boolean,
    label: string,
    type?: string,
    id: string,
    required?: boolean
    register: UseFormRegister<any>,
}

function FormInput(props: FormInputProps) {
    const {
        horizontal,
        label,
        type,
        id,
        required,
        register } = props;

    return (
        <div className={`input-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="input-label">{label}:</div>
            <div className="input-input">
                <input
                    type={type ?? "string"}
                    {...register(id)}
                    id={id}
                    required={required}
                    style={{
                        width: "100%"
                    }}
                />
            </div>
        </div>
    )
}

export default FormInput;