import {DTOs} from "../../../shared/dto/dtos";
import Form from "../../../shared/form/Form";
import {useCallback, useEffect, useState} from "react";
import {useForm, UseFormReturn, useWatch} from "react-hook-form";
import FormInput from "../../../shared/form/FormInput";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import FormSelect from "../../../shared/form/FormSelect";
import ChainFormSelect from "./ChainFormSelect";
import ChainFormSelectList from "./ChainFormSelectList";
import ChainDTO = DTOs.ChainDTO;
import ChainType = DTOs.ChainType;
import ChildChainDTO = DTOs.ChildChainDTO;
import ChainSelectDTO = DTOs.ChainSelectDTO;
import chainFormSelectList from "./ChainFormSelectList";

export interface ChainFormProps {
    chain?: ChainDTO
    onSubmit: (data: ChainDTO) => void
}

function ChainForm(props: ChainFormProps) {
    const {
        chain,
        onSubmit
    } = props;

    const form = useForm<ChainDTO>();

    const baseChain = form.watch("baseChain");
    const childChains = form.watch("childChains");

    const [chains, setChains] = useState<ChainSelectDTO[]>([])

    const updateBaseChain = useCallback((baseChain: ChainSelectDTO | null) => {
        form.setValue("baseChain", baseChain);
    }, [form]);

    const updateChildChains = useCallback((childChains: ChainSelectDTO[]) => {
        form.setValue("childChains", childChains as ChildChainDTO[]);
    }, [form]);

    const filterChains = useCallback(() => {
        return chains.filter(
            (chainSelect) =>
                baseChain?.id !== chainSelect.id &&
                !childChains?.some((childChain) => childChain.id === chainSelect.id)
        );
    }, [chains, baseChain, childChains]);

    useEffect(() => {
        axios.get<ChainSelectDTO[]>(`${chainsApi}/options`)
            .then(response => setChains(response.data))
            .catch(() => {})
    }, []);

    return (
        <Form
            <ChainDTO>
            id="chain-edit"
            onSubmit={onSubmit}
            form={form}
        >
            <FormInput
                <ChainDTO>
                label="Title"
                field="title"
            />
            <FormInput
                <ChainDTO>
                label="Description"
                field="description"
            />
            <FormSelect
                <ChainDTO, ChainType>
                label="Type"
                field="type"
                options={Object.values(ChainType)}
                setValue={form.setValue}
            />
            <FormInput
                <ChainDTO>
                label="Estimation"
                field="estimation"
                type="number"
            />
            <FormInput
                <ChainDTO>
                label="Time left"
                field="timeLeft"
                type="number"
            />
            <FormInput
                <ChainDTO>
                label="Points"
                field="points"
                type="number"
            />
            <ChainFormSelect
                label="Base chain"
                chains={filterChains()}
                defaultChain={chain?.baseChain ?? undefined}
                onChange={(newBaseChain) => updateBaseChain(newBaseChain)}
            />
            <ChainFormSelectList
                chains={filterChains()}
                onChange={updateChildChains}
            />
        </Form>
    );
}

export default ChainForm;