import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import Select from "react-select";
import {useCallback, useEffect, useState} from "react";

export interface ChainSelectProps {
    chains?: ChainDTO[],
    selectedChainId?: number,
    onChange: (chain: ChainDTO | null) => void,
    dontSaveState?: boolean,
}

function ChainSelect(props: ChainSelectProps) {
    const {
        chains,
        selectedChainId,
        onChange,
        dontSaveState
    } = props;

    const [selectedChain, setSelectedChain] = useState<ChainDTO | null>(null)

    const handleChainChange = useCallback((chain: ChainDTO | null) => {
        if (!dontSaveState) {
            console.log("dupaa");
            setSelectedChain(chain);
        }
        onChange(chain);
    }, [dontSaveState, onChange]);

    useEffect(() => {
        if (chains && selectedChainId) {
            const maybeChain = chains?.find(chain => chain.id === selectedChainId);
            if(maybeChain) {
                setSelectedChain(maybeChain);
            }
        }
    }, []);

    return (
        <Select
            value={selectedChain}
            onChange={(option: ChainDTO | null) => handleChainChange(option)}
            options={chains}
            getOptionLabel={(option: ChainDTO) => `${option.id.toString()} - ${option.title}`}
            getOptionValue={(option: ChainDTO) => option.id ? option.id.toString() : ''}
            isSearchable
            isClearable
        />
    );
}

export default ChainSelect;