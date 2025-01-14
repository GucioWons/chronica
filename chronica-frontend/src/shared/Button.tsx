interface ButtonProps {
    text: string,
    outlined?: boolean,
    onClick?: () => void
}

function Button(props: ButtonProps) {
    const {
        text,
        outlined,
        onClick
    } = props;

    return (
        <div>
            <button
                className={outlined ? 'button-outlined' : 'button'}
                type="submit"
                style={{width: "100%"}}
                onClick={() => onClick ? onClick() : {} }
            >
                {text}
            </button>
        </div>
    )
}

export default Button;