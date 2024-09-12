import ChainSelect from "./ChainSelect";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import {useCallback} from "react";
import {toast} from "react-toastify";
import onChange = toast.onChange;

export interface ChainFormSelectListRowProps {
    chains: ChainDTO[],
    onChange: (chain: ChainDTO | null, index: number) => void,
    index: number
    selectedChainId: number,
}

function ChainFormSelectListRow(props: ChainFormSelectListRowProps) {
    const {
        chains, 
        onChange, 
        index,
        selectedChainId
    } = props;
    
    const onSelectedChainChange = useCallback((chain: ChainDTO | null) => {
        onChange(chain, index);
    }, [index, onChange]);
    
    return (
        <ChainSelect
            chains={chains}
            onChange={onSelectedChainChange}
            selectedChainId={selectedChainId}
        />
    )
}

export default ChainFormSelectListRow;