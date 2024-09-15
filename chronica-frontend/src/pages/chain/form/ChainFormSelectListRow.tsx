import ChainSelect from "./ChainSelect";
import {DTOs} from "../../../shared/dto/dtos";
import {useCallback} from "react";
import ChainSelectDTO = DTOs.ChainSelectDTO;
import ChainFormSelectListDeleteButton from "./ChainFormSelectListDeleteButton";

export interface ChainFormSelectListRowProps {
    chains: ChainSelectDTO[],
    onChange: (chain: ChainSelectDTO | null, index: number) => void,
    onDelete: (index: number) => void,
    index: number
    defaultChain: ChainSelectDTO,
}

function ChainFormSelectListRow(props: ChainFormSelectListRowProps) {
    const {
        chains, 
        onChange,
        onDelete,
        index,
        defaultChain
    } = props;
    
    return (
        <div>
            <ChainSelect
                chains={chains}
                onChange={(chain) => onChange(chain, index)}
                defaultChain={defaultChain}
            />
            <ChainFormSelectListDeleteButton
                onClick={() => onDelete(index)}
            />
        </div>
    )
}

export default ChainFormSelectListRow;