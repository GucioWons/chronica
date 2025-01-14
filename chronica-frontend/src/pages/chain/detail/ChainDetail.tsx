import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import Detail from "../../../shared/Detail";
import TextField from "../../../shared/TextField";
import Button from "../../../shared/Button";
import {useCallback} from "react";
import {useNavigate} from "react-router";

export interface ChainDetailProps {
    chain?: ChainDTO
}

function ChainDetail(props: ChainDetailProps) {
    const { chain } = props;

    const navigate = useNavigate();

    const editChain = useCallback(() => {
        navigate("edit")
    }, [navigate]);

    if (!chain) {
        return <div>Loading...</div>
    }

    return (
        <Detail
            header={chain.title}
            button={
                <Button
                    text="Edit"
                    outlined
                    onClick={editChain}
                />
            }
        >
            <TextField text={chain.description} label={"Description"} />
            <TextField text={chain.type} label={"Type"} horizontal />
            <TextField text={chain.estimation?.toString() ?? ""} label={"Estimation"} horizontal />
            <TextField text={chain.timeLeft?.toString() ?? ""} label={"Time left"} horizontal />
            <TextField text={chain.points?.toString() ?? ""} label={"Points"} horizontal />
            <TextField text={chain.baseChain?.title ?? ""} label={"Title"} horizontal />
        </Detail>
    );
}

export default ChainDetail;