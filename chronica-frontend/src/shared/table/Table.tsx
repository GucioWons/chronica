import {TableHeader} from "./TableHeader";
import TableHeaderRow from "./TableHeaderRow";
import TableContent from "./TableContent";

export interface TableProps<T> {
    objects: T[],
    headers: TableHeader<T>[]
}

function Table<T>(props: TableProps<T>) {
    console.log("table")
    const {
        objects,
        headers
    } = props;

    return (
        <div>
            <TableHeaderRow headers={headers}/>
            <TableContent
                <T>
                objects={objects}
                headers={headers}
            />
        </div>
    );
}

export default Table