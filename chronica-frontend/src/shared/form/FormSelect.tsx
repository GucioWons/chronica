import {FieldValues, Path, PathValue} from "react-hook-form";
import {UseFormSetValue} from "react-hook-form/dist/types/form";
import {useCallback} from "react";

export interface FormSelectProps<T extends FieldValues, O extends string | object> {
    setValue?: UseFormSetValue<T>
    horizontal?: boolean,
    label: string,
    options: O[]
    field: Path<T>,
}

function FormSelect<T extends FieldValues, O extends string | object>(props: FormSelectProps<T, O>) {
    const {
        setValue,
        horizontal,
        label,
        options,
        field
    } = props

    const findOption = useCallback((selected: string) => {
        return options.find(option => option.toString() === selected)
    }, [options]);

    const onChange = useCallback((selected: string) => {
        const selectedOption = findOption(selected);
        if (selectedOption && setValue) {
            setValue(field, selectedOption as PathValue<T, Path<T>>)
        }
    }, [field, findOption, setValue]);

    return (
        <div className={`input-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="input-label">{label}:</div>
            <div className="input-input">
                <select
                    className="basic-select"
                    onChange={(e) => onChange(e.target.value)}
                >
                    {options.map((option) => {
                        return (
                            <option key={option.toString()} value={option.toString()}>
                                {option.toString()}
                            </option>
                        );
                    })}
                </select>
            </div>
        </div>
    )
}

export default FormSelect;