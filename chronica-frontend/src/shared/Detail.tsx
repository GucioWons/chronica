import React from "react";

export interface DetailProps {
    header?: string,
    children: React.ReactNode,
}

function Detail(props: DetailProps) {
    const {
        header,
        children
    } = props;

    return (
        <div className="detail">
            {header &&
            <div className="detail-header">
                {header}
            </div>
            }
            <div className="detail-content">
                {children}
            </div>
        </div>
    )
}

export default Detail;