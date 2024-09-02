import {TableHeader} from "./TableHeader";
import TableRow from "./TableRow";

export interface TableContentProps<T> {
    objects: T[],
    headers: TableHeader<T>[],
}

function TableContent<T>(props: TableContentProps<T>) {
    return (
        <>
            {props.objects.map((object: T) => (
                <TableRow
                    <T>
                    object={object}
                    headers={props.headers}
                />
            ))}
        </>
    );
}

export default TableContent;