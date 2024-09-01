import React from "react";

export interface DetailProps {
    header?: string,
    children: React.ReactNode,
    button?: React.ReactNode,
}

function Detail(props: DetailProps) {
    const {
        header,
        children,
        button
    } = props;

    return (
        <div className="detail">
            {header &&
            <div className="detail-header">
                {header}
                {button}
            </div>
            }
            <div className="detail-content">
                {children}
            </div>
        </div>
    )
}

export default Detail;