import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import ChainSelect from "./ChainSelect";
import {useCallback, useState} from "react";
import ChainFormSelectListRow from "./ChainFormSelectListRow";

export interface ChainFormSelectListProps {
    chains: ChainDTO[]
    onChange: (chain: ChainDTO[]) => void
}

function ChainFormSelectList(props: ChainFormSelectListProps) {
    const [selectedChains, setSelectedChains] = useState<ChainDTO[]>([])

    const addSelectedChain = useCallback((chain: ChainDTO | null) => {
        if (chain) {
            let newSelectedChains = [...selectedChains];
            newSelectedChains.push(chain);
            setSelectedChains(newSelectedChains);
        }
    }, [selectedChains, setSelectedChains]);

    const updateSelectedChain = useCallback((chain: ChainDTO | null, index: number) => {
        let newSelectedChains = [...selectedChains];
        if (chain) {
            newSelectedChains[index] = chain;
        } else {
            delete newSelectedChains[index];
        }
        setSelectedChains(newSelectedChains);
    }, [selectedChains, setSelectedChains])

    return(
        <div className={`input-with-label vertical`}>
            <div className="input-label">Related chains:</div>
            <ChainSelect
                chains={props.chains}
                onChange={addSelectedChain}
                dontSaveState
            />
            {selectedChains.map((chain, index) => (
                <ChainFormSelectListRow
                    chains={props.chains}
                    onChange={updateSelectedChain}
                    index={index}
                    selectedChainId={chain.id}
                />
            ))}
        </div>
    );
}

export default ChainFormSelectList;