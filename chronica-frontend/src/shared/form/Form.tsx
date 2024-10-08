import React, {useEffect} from "react";
import {FieldValues, SubmitHandler, UseFormReturn} from "react-hook-form";
import SubmitButton from "../SubmitButton";
import FormInput, {FormInputProps} from "./FormInput";

interface FormProps<T extends FieldValues> {
    id: string,
    children: React.ReactNode,
    onSubmit: (data: T) => void,
    form: UseFormReturn<T, any, undefined>
    submitText?: string,
    defaultValues?: T
}

function Form<T extends FieldValues>(props: FormProps<T>) {
    const {
        id,
        children,
        onSubmit,
        form,
        submitText,
        defaultValues
    } = props;

    useEffect(() => {
        if (defaultValues) {
            console.log("twoja stara 7")
            form.reset(defaultValues);
        }
    }, [defaultValues]);

    const cloneWithRegister = (child: React.ReactNode): React.ReactNode => {
        if (React.isValidElement(child) && child.type === FormInput) {
            return React.cloneElement(child as React.ReactElement<FormInputProps<any>>, {
                register: form.register,
                id: id
            });
        } else {
            return child;
        }
    };

    const handleOnSubmit: SubmitHandler<T> = ((data, event) => {
        event?.preventDefault();
        onSubmit(data);
    });

    return (
        <form onSubmit={form.handleSubmit(handleOnSubmit)}>
            {React.Children.map(children, (child) => cloneWithRegister(child))}
            <SubmitButton text={submitText ?? "OK"} />
        </form>
    )
}

export default Form;