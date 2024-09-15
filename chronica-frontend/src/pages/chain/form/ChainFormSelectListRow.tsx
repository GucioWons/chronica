import ChainSelect from "./ChainSelect";
import {DTOs} from "../../../shared/dto/dtos";
import {useCallback} from "react";
import ChainSelectDTO = DTOs.ChainSelectDTO;

export interface ChainFormSelectListRowProps {
    chains: ChainSelectDTO[],
    onChange: (chain: ChainSelectDTO | null, index: number) => void,
    index: number
    defaultChain: ChainSelectDTO,
}

function ChainFormSelectListRow(props: ChainFormSelectListRowProps) {
    const {
        chains, 
        onChange, 
        index,
        defaultChain
    } = props;
    
    const onSelectedChainChange = useCallback((chain: ChainSelectDTO | null) => {
        onChange(chain, index);
    }, [index, onChange]);
    
    return (
        <ChainSelect
            chains={chains}
            onChange={onSelectedChainChange}
            defaultChain={defaultChain}
        />
    )
}

export default ChainFormSelectListRow;