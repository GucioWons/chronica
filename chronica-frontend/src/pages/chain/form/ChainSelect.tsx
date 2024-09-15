import {DTOs} from "../../../shared/dto/dtos";
import Select from "react-select";
import {useCallback, useState} from "react";
import ChainSelectDTO = DTOs.ChainSelectDTO;

export interface ChainSelectProps {
    chains?: ChainSelectDTO[],
    defaultChain?: ChainSelectDTO,
    onChange: (chain: ChainSelectDTO | null) => void,
    dontSaveState?: boolean,
}

function ChainSelect(props: ChainSelectProps) {
    const {
        chains,
        defaultChain,
        onChange,
        dontSaveState
    } = props;

    const [selectedChain, setSelectedChain] = useState<ChainSelectDTO | null>(defaultChain ?? null)

    const handleChainChange = useCallback((chain: ChainSelectDTO | null) => {
        if (!dontSaveState) {
            setSelectedChain(chain);
        }
        onChange(chain);
    }, [dontSaveState, onChange]);

    return (
        <Select
            value={selectedChain}
            onChange={(option: ChainSelectDTO | null) => handleChainChange(option)}
            options={chains}
            getOptionLabel={(option: ChainSelectDTO) => `${option.id.toString()} - ${option.title}`}
            getOptionValue={(option: ChainSelectDTO) => option.id ? option.id.toString() : ''}
            isSearchable
            isClearable
        />
    );
}

export default ChainSelect;