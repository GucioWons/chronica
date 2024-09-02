import {TableHeader} from "./TableHeader";

export interface TableHeaderRowProps {
    headers: TableHeader<any>[]
}

function TableHeaderRow(props: TableHeaderRowProps) {
    console.log("hrow")
    return (
        <div className="table-header-row">
            {props.headers.map((header) => {
                return (
                    <div className="table-header-cell">{header.name}</div>
                );
            })}
        </div>
    )
}

export default TableHeaderRow;