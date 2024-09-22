package org.chronica.library.exception.dto.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    UNEXPECTED_EXCEPTION,
    NOT_IMPLEMENTED_EXCEPTION,

    NO_ENTITY_EXCEPTION,

    INHERITANCE_LEVEL_EXCEPTION,
    INHERITANCE_LOOP_EXCEPTION,

    WRONG_MAPPER_EXCEPTION,

    AUTHORIZATION_EXCEPTION,
    UNEXPECTED_JWT_EXCEPTION,
    EXPIRED_ACCESS_TOKEN_EXCEPTION;
}
