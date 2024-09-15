import {DTOs} from "../../../shared/dto/dtos";
import ChainSelect from "./ChainSelect";
import {useCallback, useState} from "react";
import ChainFormSelectListRow from "./ChainFormSelectListRow";
import ChainDTO = DTOs.ChainDTO;
import ChainSelectDTO = DTOs.ChainSelectDTO;

export interface ChainFormSelectListProps {
    chains: ChainSelectDTO[]
    onChange: (chain: ChainDTO[]) => void
}

function ChainFormSelectList(props: ChainFormSelectListProps) {
    const [selectedChains, setSelectedChains] = useState<ChainSelectDTO[]>([])

    const addSelectedChain = useCallback((chain: ChainSelectDTO | null) => {
        if (chain) {
            let newSelectedChains = [...selectedChains];
            newSelectedChains.push(chain);
            setSelectedChains(newSelectedChains);
        }
    }, [selectedChains, setSelectedChains]);

    const updateSelectedChain = useCallback((chain: ChainSelectDTO | null, index: number) => {
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
                    defaultChain={chain}
                />
            ))}
        </div>
    );
}

export default ChainFormSelectList;