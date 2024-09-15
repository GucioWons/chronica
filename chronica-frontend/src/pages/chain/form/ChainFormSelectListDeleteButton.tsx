export interface ChainFormSelectListDeleteButtonProps {
    onClick: () => void
}

function ChainFormSelectListDeleteButton(props: ChainFormSelectListDeleteButtonProps) {
    const {onClick} = props;

    return (
        <button onClick={() => onClick()}>Delete</button>
    )
}

export default ChainFormSelectListDeleteButton;
