import {TableHeader} from "./TableHeader";
import TableRow from "./TableRow";

export interface TableContentProps<T> {
    objects: T[],
    headers: TableHeader<T>[],
    onRowClick?: (row: T) => void
}

function TableContent<T>(props: TableContentProps<T>) {
    return (
        <>
            {props.objects.map((object: T, index) => (
                <TableRow
                    <T>
                    object={object}
                    headers={props.headers}
                    index={index}
                    onClick={props.onRowClick}
                />
            ))}
        </>
    );
}

export default TableContent;