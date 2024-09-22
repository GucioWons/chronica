package org.chronica.library.exception.dto.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    UNEXPECTED_EXCEPTION("Unexpected error has occured."),
    NOT_IMPLEMENTED_EXCEPTION("This function is not implemented."),

    NO_ENTITY_EXCEPTION("Could not find ${className} with id ${id}."),

    INHERITANCE_LEVEL_EXCEPTION("Chain cannot be Base Chain of Chain with the same or lower type."),
    INHERITANCE_LOOP_EXCEPTION("Chains inheritance cannot be looped."),

    WRONG_MAPPER_EXCEPTION("Its something wrong with entity/mapper couldn't work."),

    AUTHORIZATION_EXCEPTION("Wrong email or password."),
    UNEXPECTED_JWT_EXCEPTION("Unexpected JWT error occured."),
    EXPIRED_ACCESS_TOKEN_EXCEPTION("The access token has expired, sing in again, or refresh access token using refresh token.");

    private final String en;
}
