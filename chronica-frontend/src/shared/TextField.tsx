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
            <div className="textfield-label ${horizontal ? 'horizontal' : 'vertical'">{label}:</div>
            <div className="textfield-text ${horizontal ? 'horizontal' : 'vertical'" >{text}</div>
        </div>
    )
}

export default TextField;