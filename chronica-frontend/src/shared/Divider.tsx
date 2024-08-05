import {CSSProperties, ReactNode } from "react";

interface DividerProps {
    direction: 'horizontal' | 'vertical',
    leftOrTopContent: ReactNode,
    rightOrBottomContent: ReactNode,
    className?: string,
    style?: CSSProperties,
}

function Divider(props: DividerProps) {
    const {
        direction,
        leftOrTopContent,
        rightOrBottomContent,
        className,
        style
    } = props;
    return (
        <div
            className={className}
            style={{
                display: 'flex',
                flexDirection: direction === 'horizontal' ? 'row' : 'column',
                ...style
            }}
        >
            <div style={{ flex: 1 }}>
                {leftOrTopContent}
            </div>
            <div style={{ flex: 1 }}>
                {rightOrBottomContent}
            </div>
        </div>
    );
}

export default Divider;