package org.chronica.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChronicaException extends RuntimeException {
    private final ExceptionMessage exceptionMessage;
}
