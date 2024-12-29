import {useAuth} from "../../context/useAuth";
import {AxiosError} from "axios";
import {toast} from "react-toastify";
import {DTOs} from "../dto/dtos";
import {ErrorMessages} from "../ErrorMessages";
import ErrorDTO = DTOs.ErrorDTO;
import ErrorMessage = DTOs.ErrorMessage;

export const useErrorHandler = () => {
    const getErrorMessage = (errorMesage: ErrorMessage, lang: string) => {
        return ErrorMessages[lang][errorMesage] || ErrorMessages["en"][ErrorMessage.UNEXPECTED_EXCEPTION];
    };

    const formatNoEntityMessage = (message: string, properties: { [index: string]: any }) => {
        return message
            .replace("{className}", properties["className"])
            .replace("{id}", properties["id"]);
    };

    const handleError = (error: AxiosError) => {
        if (error.response) {
            const errorData: ErrorDTO = error.response.data as ErrorDTO;
            if (errorData.message === ErrorMessage.UNEXPECTED_EXCEPTION || errorData.message === ErrorMessage.NOT_IMPLEMENTED_EXCEPTION) {
                toast.error(getErrorMessage(errorData.message, "en"));
            } else if (errorData.message === ErrorMessage.NO_ENTITY_EXCEPTION) {
                toast.warning(formatNoEntityMessage(getErrorMessage(errorData.message, "en"), errorData.properties));
            } else if (errorData.message === ErrorMessage.EXPIRED_ACCESS_TOKEN_EXCEPTION || errorData.message === ErrorMessage.UNEXPECTED_JWT_EXCEPTION) {
                // refreshUsersToken(error.config);
            } else {
                toast.warning(getErrorMessage(errorData.message, "en"));
            }
        } else if (error.request) {
            toast.error("Cannot get response from the server.");
        } else {
            toast.error("Bad request.");
        }
    };

    return handleError;
};