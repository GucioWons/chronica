interface SubmitButtonProps {
    text: string,
}

function SubmitButton(props: SubmitButtonProps) {
    const { text } = props;

    return (
        <div>
            <button
                type="submit"
                style={{width: "100%"}}
            >
                {text}
            </button>
        </div>
    )
}

export default SubmitButton;