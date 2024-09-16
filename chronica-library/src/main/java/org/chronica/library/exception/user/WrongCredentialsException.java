package org.chronica.library.exception.user;

import org.chronica.library.commons.exception.ChronicaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongCredentialsException extends ChronicaException {
    public WrongCredentialsException(String message) {
        super(message);
    }
}
