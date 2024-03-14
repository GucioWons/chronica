package com.chronica.user.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountDoesntExistException extends IllegalArgumentException {
    public AccountDoesntExistException(String message) {
        super(message);
    }
}
