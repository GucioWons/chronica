package org.chronica.library.exception;

import lombok.Getter;

@Getter
public class NoEntityException extends ChronicaException {
    private final String className;
    private final Long id;

    public NoEntityException(ExceptionMessage exceptionMessage, String className, Long id) {
        super(exceptionMessage);
        this.className = className;
        this.id = id;
    }
}
