import ChainSelect from "./ChainSelect";
import {DTOs} from "../../../shared/dto/dtos";
import ChainSelectDTO = DTOs.ChainSelectDTO;

export interface ChainFormSelectProps {
    chains?: ChainSelectDTO[],
    defaultChain?: ChainSelectDTO,
    onChange: (chain: ChainSelectDTO | null) => void,
    horizontal?: boolean,
    label: string,
}

function ChainFormSelect(props: ChainFormSelectProps) {
    const {
        chains,
        defaultChain,
        onChange,
        horizontal,
        label,
    } = props;

    return (
        <div className={`input-with-label ${horizontal ? 'horizontal' : 'vertical'}`}>
            <div className="input-label">{label}:</div>
            <div className="input-input">
                <ChainSelect
                    chains={chains}
                    defaultChain={defaultChain}
                    onChange={onChange}
                    isClearable
                />
            </div>
        </div>
    )
}

export default ChainFormSelect;