interface SubmitButtonProps {
    onSubmit: any,
    text: string,
}

function SubmitButton(props: SubmitButtonProps) {
    const { onSubmit, text } = props;

    return (
        <div>
            <button>
                {text}
            </button>
        </div>
    )
}

export default SubmitButton;