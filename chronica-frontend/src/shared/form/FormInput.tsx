import {FieldValues, UseFormRegister, Path} from "react-hook-form";

export interface FormInputProps<T extends FieldValues> {
    horizontal?: boolean,
    label: string,
    type?: string,
    field: Path<T>,
    id?: string,
    required?: boolean
    register?: UseFormRegister<T>,
}

function FormInput<T extends FieldValues>(props: FormInputProps<T>) {
    const {
        horizontal,
        label,
        type,
        field,
        id,
        required,
        register } = props;

    return (
        <div className={`input-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="input-label">{label}:</div>
            <div className="input-input">
                <input
                    type={type ?? "string"}
                    {...register?.(field)}
                    required={required}
                    id={id + "-" + field}
                    style={{
                        width: "100%"
                    }}
                />
            </div>
        </div>
    )
}

export default FormInput;