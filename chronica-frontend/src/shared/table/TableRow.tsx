import {TableHeader} from "./TableHeader";
import TableCell from "./TableCell";

export interface TableRowProps<T> {
    object: T
    headers: TableHeader<T>[];
}

function TableRow<T>(props: TableRowProps<T>) {
    const {
        object,
        headers
    } = props;
    return (
        <div>
            {headers.map((header) => (
                <TableCell value = {object[header.field] as string}/>
            ))}
        </div>
    )
}

export default TableRow;