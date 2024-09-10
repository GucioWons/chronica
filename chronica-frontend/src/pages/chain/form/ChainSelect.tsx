import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import Select from "react-select";
import {useCallback, useEffect, useState} from "react";

export interface ChainSelectProps {
    chains?: ChainDTO[],
    selectedChainId?: number,
    onChange: (chain: ChainDTO | null) => void,
    horizontal?: boolean,
    label: string
}

function ChainSelect(props: ChainSelectProps) {
    const {
        chains,
        selectedChainId,
        onChange,
        horizontal,
        label
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
        <div className={`input-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="input-label">{label}:</div>
            <div className="input-input chain-select">
                <div className="chain-select-id">
                    <Select
                        value={selectedChain}
                        onChange={(option: ChainDTO | null) => handleChainChange(option)}
                        options={chains}
                        getOptionLabel={(option: ChainDTO) => option.id.toString()}
                        getOptionValue={(option: ChainDTO) => option.id ? option.id.toString() : ''}
                        isSearchable
                        isClearable
                    />
                </div>
                <div className="chain-select-title">
                    <Select
                        value={selectedChain}
                        onChange={(option: ChainDTO | null) => handleChainChange(option)}
                        options={chains}
                        getOptionLabel={(option: ChainDTO) => option.title}
                        getOptionValue={(option: ChainDTO) => option.id ? option.id.toString() : ''}
                        isSearchable
                        isClearable
                    />
                </div>
            </div>
        </div>
    );
}

export default ChainSelect;