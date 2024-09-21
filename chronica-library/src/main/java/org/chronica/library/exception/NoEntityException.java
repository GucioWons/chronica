package org.chronica.library.exception;

import lombok.Getter;

@Getter
public class NoEntityException extends ChronicaException {
    private final String className;
    private final Long id;

    public NoEntityException(String className, Long id) {
        super(ExceptionMessage.NO_ENTITY_EXCEPTION);
        this.className = className;
        this.id = id;
    }
}
