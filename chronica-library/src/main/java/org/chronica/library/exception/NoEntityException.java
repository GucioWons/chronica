package org.chronica.library.exception;

import lombok.Getter;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;

@Getter
public class NoEntityException extends ChronicaException {
    private final String className;
    private final Long id;

    public NoEntityException(String className, Long id) {
        super(ErrorMessage.NO_ENTITY_EXCEPTION);
        this.className = className;
        this.id = id;
    }
}
