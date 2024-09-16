package com.chronica.chain.util;

import org.chronica.library.exception.chain.InheritanceException;
import org.chronica.library.exception.chain.NoChainException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ChainExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NoChainException.class })
    protected ResponseEntity<Object> handleNoChainException(NoChainException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { InheritanceException.class })
    protected ResponseEntity<Object> handleNoChainException(InheritanceException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }
}
