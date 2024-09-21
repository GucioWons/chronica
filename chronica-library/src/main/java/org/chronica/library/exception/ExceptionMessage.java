package org.chronica.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    NO_ENTITY_EXCEPTION("Could not find ${className} with id ${id}"),
    INHERITANCE_EXCEPTION_LEVEL("Chain cannot be Base Chain of Chain with the same or lower type."),
    INHERITANCE_EXCEPTION_LOOP("Chains inheritance cannot be looped."),
    WRONG_MAPPER("Its something wrong with entity/mapper couldnt work"),
    EXPIRED_ACCESS_TOKEN("The access token has expired, sing in again, or refresh access token using refresh token.");

    private final String en;
}
