interface SubmitButtonProps {
    onSubmit: () => void,
    text: string,
}

function SubmitButton(props: SubmitButtonProps) {
    const { onSubmit, text } = props;

    return (
        <div>
            <button
                onSubmit={onSubmit}
                style={{width: "100%"}}
            >
                {text}
            </button>
        </div>
    )
}

export default SubmitButton;