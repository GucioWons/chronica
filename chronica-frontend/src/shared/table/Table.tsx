import {TableHeader} from "./TableHeader";
import TableHeaderRow from "./TableHeaderRow";
import TableContent from "./TableContent";

export interface TableProps<T> {
    objects: T[],
    headers: TableHeader<T>[]
    onRowClick?: (row: T) => void
}

function Table<T>(props: TableProps<T>) {
    const {
        objects,
        headers,
        onRowClick
    } = props;

    return (
        <div className="basic-table">
            <TableHeaderRow headers={headers}/>
            <TableContent
                <T>
                objects={objects}
                headers={headers}
                onRowClick={onRowClick}
            />
        </div>
    );
}

export default Table