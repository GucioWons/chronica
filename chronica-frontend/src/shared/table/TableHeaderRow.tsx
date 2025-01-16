import {TableHeader} from "./TableHeader";

export interface TableHeaderRowProps {
    headers: TableHeader<any>[]
}

function TableHeaderRow(props: TableHeaderRowProps) {

    const getCellClass = (index: number, length: number): string => {
        if (index === 0) return 'first';
        if (index === length - 1) return 'last';
        return 'middle';
    };

    return (
        <div className="table-row header">
            {props.headers.map((header, index) => {
                return (
                    <div className={`table-cell header ${getCellClass(index, props.headers.length)}`}>{header.name}</div>
                );
            })}
        </div>
    )
}

export default TableHeaderRow;