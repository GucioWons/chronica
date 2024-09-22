package org.chronica.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;

@Getter
@AllArgsConstructor
public class ChronicaException extends RuntimeException {
    private final ErrorMessage errorMessage;
}
