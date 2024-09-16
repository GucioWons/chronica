package com.chronica.group.exception;

import org.chronica.library.exception.group.NoGroupException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NoGroupExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NoGroupException.class })
    protected ResponseEntity<Object> toResponse(NoGroupException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
