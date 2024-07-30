import React, {useEffect} from "react";
import {FieldValues, SubmitHandler, useForm, UseFormReturn} from "react-hook-form";
import SubmitButton from "./SubmitButton";
import FormInput, {FormInputProps} from "./FormInput";

interface FormProps<T extends FieldValues> {
    id: string,
    children: React.ReactNode,
    onSubmit: (data: T) => void,
    setMethods: (methods: UseFormReturn<T>) => void,
    submitText?: string;
}

function Form<T extends FieldValues>(props: FormProps<T>) {
    const {
        id,
        children,
        onSubmit,
        setMethods,
        submitText
    } = props;

    const methods = useForm<T>();

    useEffect(() => {
        if (setMethods) {
            setMethods(methods);
        }
    }, [methods, setMethods]);

    const cloneWithRegister = (child: React.ReactNode): React.ReactNode => {
        if (React.isValidElement(child) && child.type === FormInput) {
            return React.cloneElement(child as React.ReactElement<FormInputProps<any>>, {
                register: methods.register,
                id: id
            });
        }
    };

    const handleOnSubmit: SubmitHandler<T> = ((data, event) => {
        event?.preventDefault();
        onSubmit(data);
    });

    return (
        <form onSubmit={methods.handleSubmit(handleOnSubmit)}>
            {React.Children.map(children, (child) => cloneWithRegister(child))}
            <SubmitButton text={submitText ?? "OK"} />
        </form>
    )
}

export default Form;