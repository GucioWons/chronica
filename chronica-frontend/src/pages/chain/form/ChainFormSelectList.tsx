import {DTOs} from "../../../shared/dto/dtos";
import ChainSelect from "./ChainSelect";
import {useCallback, useEffect, useState} from "react";
import ChainFormSelectListRow from "./ChainFormSelectListRow";
import ChainSelectDTO = DTOs.ChainSelectDTO;

export interface ChainFormSelectListProps {
    chains: ChainSelectDTO[]
    onChange: (chain: ChainSelectDTO[]) => void
    defaultChains: ChainSelectDTO[]
}

function ChainFormSelectList(props: ChainFormSelectListProps) {
    const {
        chains,
        onChange,
        defaultChains
    } = props;

    const [selectedChains, setSelectedChains] = useState<ChainSelectDTO[]>([])

    const addSelectedChain = useCallback((chain: ChainSelectDTO | null) => {
        if (chain) {
            let newSelectedChains = [...selectedChains];
            newSelectedChains.push(chain);
            setSelectedChains(newSelectedChains);
            onChange(newSelectedChains);
        }
    }, [selectedChains, setSelectedChains, onChange]);

    const updateSelectedChain = useCallback((chain: ChainSelectDTO | null, index: number) => {
        if (chain) {
            let newSelectedChains = [...selectedChains];
            newSelectedChains[index] = chain;
            setSelectedChains(newSelectedChains);
            onChange(newSelectedChains);
        }
    }, [selectedChains, setSelectedChains, onChange])

    const deleteSelectedChain = useCallback((index: number) => {
        let newSelectedChains = [...selectedChains];
        newSelectedChains = newSelectedChains.filter((_, i) => i !== index);
        setSelectedChains(newSelectedChains);
        onChange(newSelectedChains);
    },[selectedChains, setSelectedChains, onChange])

    useEffect(() => {
        setSelectedChains(defaultChains)
    }, [defaultChains]);

    return(
        <div className={`input-with-label vertical`}>
            <div className="input-label">Related chains:</div>
            <ChainSelect
                chains={chains}
                onChange={addSelectedChain}
                dontSaveState
            />
            {selectedChains.map((chain, index) => (
                <ChainFormSelectListRow
                    chains={chains}
                    onChange={updateSelectedChain}
                    onDelete={deleteSelectedChain}
                    index={index}
                    defaultChain={chain}
                />
            ))}
        </div>
    );
}

export default ChainFormSelectList;