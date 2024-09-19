package org.chronica.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoEntityException extends RuntimeException {
    private final String className;
    private final Long id;
}
