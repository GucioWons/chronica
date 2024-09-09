import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import Select from "react-select";
import {useCallback, useEffect, useState} from "react";

export interface ChainFormInputProps {
    chains?: ChainDTO[],
    selectedChainId?: number,
    onChange: (chain: ChainDTO | null) => void,
}

function ChainFormInput(props: ChainFormInputProps) {
    const {
        chains,
        selectedChainId,
        onChange
    } = props;

    const [selectedChain, setSelectedChain] = useState<ChainDTO | null>(null)

    const handleChainChange = useCallback((chain: ChainDTO | null) => {
        setSelectedChain(chain);
        onChange(chain);
    }, [onChange]);

    useEffect(() => {
        if (chains && selectedChainId) {
            const maybeChain = chains?.find(chain => chain.id === selectedChainId);
            if(maybeChain) {
                setSelectedChain(maybeChain);
            }
        }
    }, []);
    
    return(
        <div>
            <Select
                value={selectedChain}
                onChange={(option: ChainDTO | null) => handleChainChange(option)}
                options={chains}
                getOptionLabel={(option: ChainDTO) => option.title}
                getOptionValue={(option: ChainDTO) => option.id ? option.id.toString() : ''}
                isSearchable
            />
        </div>
    );
}

export default ChainFormInput;