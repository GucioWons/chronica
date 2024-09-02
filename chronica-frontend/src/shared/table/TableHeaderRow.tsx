import {TableHeader} from "./TableHeader";

export interface TableHeaderRowProps {
    headers: TableHeader<any>[]
}

function TableHeaderRow(props: TableHeaderRowProps) {
    return (
        <div>
            <TableHeaderRow headers={props.headers} />
            {props.headers.map((header) => {
                return (
                    <div>{header.name}</div>
                );
            })}
        </div>
    )
}

export default TableHeaderRow;