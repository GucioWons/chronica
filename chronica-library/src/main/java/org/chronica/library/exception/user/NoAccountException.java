package org.chronica.library.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoAccountException extends RuntimeException {
    public NoAccountException(String message) {
        super(message);
    }
}
