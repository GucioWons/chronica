export interface TextFieldProps {
    text: string,
    label: string,
    horizontal?: boolean,
}

function TextField(props: TextFieldProps) {
    const {
        text,
        label,
        horizontal
    } = props;
    return (
        <div className={`textfield-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="textfield-label">{label}:</div>
            <div className="textfield-text">{text}</div>
        </div>
    )
}

export default TextField;