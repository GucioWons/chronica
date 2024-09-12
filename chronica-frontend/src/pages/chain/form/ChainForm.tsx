import {DTOs} from "../../../shared/dto/dtos";
import ChainDTO = DTOs.ChainDTO;
import Form from "../../../shared/form/Form";
import {useNavigate} from "react-router";
import {useCallback, useEffect, useState} from "react";
import {UseFormReturn} from "react-hook-form";
import FormInput from "../../../shared/form/FormInput";
import axios from "axios";
import {chainsApi} from "../../../shared/apiConstants";
import ChainSelect from "./ChainSelect";
import FormSelect from "../../../shared/form/FormSelect";
import ChainType = DTOs.ChainType;
import {toast} from "react-toastify";
import BaseChainDTO = DTOs.BaseChainDTO;
import ChainFormSelect from "./ChainFormSelect";
import ChainFormSelectList from "./ChainFormSelectList";
import ChildChainDTO = DTOs.ChildChainDTO;

export interface ChainFormProps {
    chain?: ChainDTO
}

function ChainForm(props: ChainFormProps) {
    const { chain } = props;

    const editMode: boolean = !!chain;
    
    const navigate = useNavigate();

    const [ formMethods, setFormMethods ] = useState<UseFormReturn<ChainDTO> | null>(null);

    const [chains, setChains] = useState<ChainDTO[]>([])

    const onSubmit = (data: ChainDTO) => {
        if (editMode) {
            // handleEdition(data);
        } else {
            handleCreation(data);
        }
    }

    const handleCreation = useCallback((data: ChainDTO) => {
        axios.post<ChainDTO>(chainsApi, data)
            .then((response) => {
                toast.success("Successfully created chain!");
                navigate("/chains/" + response.data.id);
            })
            .catch(() => toast.error("Could not create chain!"));
    }, [navigate]);

    const updateBaseChain = useCallback((baseChain: ChainDTO | null) => {
        formMethods?.setValue("baseChain", baseChain as BaseChainDTO);
    }, [formMethods]);

    const updateChildChains = useCallback((childChains: ChainDTO[]) => {
        formMethods?.setValue("childChains", childChains as ChildChainDTO[]);
    }, [formMethods]);

    useEffect(() => {
        axios.get<ChainDTO[]>(chainsApi)
            .then(response => setChains(response.data))
            .catch(() => {})
    }, []);

    return (
        <Form
            <ChainDTO>
            id="chain-edit"
            onSubmit={onSubmit}
            setMethods={setFormMethods}
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
                setValue={formMethods?.setValue}
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
                chains={chains}
                selectedChainId={chain?.baseChain?.id}
                onChange={(newBaseChain) => updateBaseChain(newBaseChain)}
            />
            <ChainFormSelectList
                chains={chains}
                onChange={updateChildChains}
            />
        </Form>
    );
}

export default ChainForm;