package org.chronica.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    NO_ENTITY_EXCEPTION("Could not find ${className} with id ${id}");

    private final String en;
}
