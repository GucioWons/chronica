import {TableHeader} from "./TableHeader";
import TableCell from "./TableCell";

export interface TableRowProps<T> {
    object: T,
    headers: TableHeader<T>[],
    index: number
}

function TableRow<T>(props: TableRowProps<T>) {
    const {
        object,
        headers,
        index
    } = props;
    return (
        <div className={index % 2 === 0 ? "table-row-light" : "table-row-dark"}>
            {headers.map((header) => (
                <TableCell value={object[header.field] as string} />
            ))}
        </div>
    )
}

export default TableRow;