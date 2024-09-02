export interface TableCellProps {
    value: string | number
}

function TableCell(props: TableCellProps) {
    return (
        <div>{props.value}</div>
    )
}

export default TableCell;