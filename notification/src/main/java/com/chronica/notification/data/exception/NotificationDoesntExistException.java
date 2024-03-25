package com.chronica.notification.data.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotificationDoesntExistException  extends IllegalArgumentException {
    public NotificationDoesntExistException(String message) {
        super(message);
    }
}
