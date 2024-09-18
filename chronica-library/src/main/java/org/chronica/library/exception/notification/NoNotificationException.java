package org.chronica.library.exception.notification;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoNotificationException extends IllegalArgumentException {
    public NoNotificationException(String message) {
        super(message);
    }
}
