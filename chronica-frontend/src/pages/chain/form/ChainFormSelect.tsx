import ChainSelect from "./ChainSelect";
import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;

export interface ChainFormSelectProps {
    chains?: ChainDTO[],
    selectedChainId?: number,
    onChange: (chain: ChainDTO | null) => void,
    horizontal?: boolean,
    label: string,
    dontSaveState?: boolean
}

function ChainFormSelect(props: ChainFormSelectProps) {
    const {
        chains,
        selectedChainId,
        onChange,
        horizontal,
        label,
        dontSaveState
    } = props;

    return (
        <div className={`input-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="input-label">{label}:</div>
            <div className="input-input">
                <ChainSelect
                    chains={chains}
                    selectedChainId={selectedChainId}
                    onChange={onChange}
                    dontSaveState
                />
            </div>
        </div>
    )
}

export default ChainFormSelect;