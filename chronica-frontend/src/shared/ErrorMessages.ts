import {DTOs} from "./dto/dtos";
import ErrorMessage = DTOs.ErrorMessage;

export const ErrorMessages: Record<string, Record<ErrorMessage, string>> = {
    en: {
        [ErrorMessage.UNEXPECTED_EXCEPTION]: "Unexpected error has occured.",
        [ErrorMessage.NOT_IMPLEMENTED_EXCEPTION]: "This function is not implemented.",
        [ErrorMessage.NO_ENTITY_EXCEPTION]: "Could not find {className} with id {id}.",
        [ErrorMessage.INHERITANCE_LEVEL_EXCEPTION]: "Chains inheritance cannot be looped.",
        [ErrorMessage.INHERITANCE_LOOP_EXCEPTION]: "Its something wrong with entity/mapper couldn't work.",
        [ErrorMessage.WRONG_MAPPER_EXCEPTION]: "Its something wrong with entity/mapper couldn't work.",
        [ErrorMessage.AUTHORIZATION_EXCEPTION]: "Wrong email or password.",
        [ErrorMessage.UNEXPECTED_JWT_EXCEPTION]: "Unexpected JWT error.",
        [ErrorMessage.EXPIRED_ACCESS_TOKEN_EXCEPTION]: "The access token has expired, sing in again, or refresh access token using refresh token.",
        [ErrorMessage.EXPIRED_REFRESH_TOKEN_EXCEPTION]: "Not implemented",
    }
};
