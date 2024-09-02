import {TableHeader} from "./TableHeader";
import TableCell from "./TableCell";

export interface TableRowProps<T> {
    object: T,
    headers: TableHeader<T>[],
    index: number
    onClick?: (row: T) => void
}

function TableRow<T>(props: TableRowProps<T>) {
    const {
        object,
        headers,
        index,
        onClick
    } = props;
    return (
        <div
            onClick={onClick ? () => onClick(object) : undefined}
            className={index % 2 === 0 ? "table-row-light" : "table-row-dark"}
        >
            {headers.map((header) => (
                <TableCell value={object[header.field] as string} />
            ))}
        </div>
    )
}

export default TableRow;