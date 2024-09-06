export interface TableCellProps {
    value: string | number
}

function TableCell(props: TableCellProps) {
    return <div className="table-cell">{props.value}</div>
}

export default TableCell;