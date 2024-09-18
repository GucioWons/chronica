import ChainSelect from "./ChainSelect";
import {DTOs} from "../../../shared/dto/dtos";
import ChainFormSelectListDeleteButton from "./ChainFormSelectListDeleteButton";
import ChainSelectDTO = DTOs.ChainSelectDTO;

export interface ChainFormSelectListRowProps {
    chains: ChainSelectDTO[],
    onChange: (chain: ChainSelectDTO | null, index: number) => void,
    onDelete: (index: number) => void,
    index: number
    defaultChain: ChainSelectDTO,
}

function ChainFormSelectListRow(props: ChainFormSelectListRowProps) {
    const {
        chains, 
        onChange,
        onDelete,
        index,
        defaultChain
    } = props;
    
    return (
        <div className="chain-child-chains-list">
            <div className="chain-child-chains-input">
            <ChainSelect
                chains={chains}
                onChange={(chain) => onChange(chain, index)}
                defaultChain={defaultChain}
            />
            </div>
            <ChainFormSelectListDeleteButton
                onClick={() => onDelete(index)}
            />
        </div>
    )
}

export default ChainFormSelectListRow;