package com.chronica.chain.exception;

import org.chronica.library.commons.dto.ErrorDTO;
import org.chronica.library.exception.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class ChainExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { InheritanceException.class })
    //TODO handle two types of exceptions
    protected ResponseEntity<Object> handleNoChainException(InheritanceException e, WebRequest request) {
        return handleExceptionInternal(e, new ErrorDTO(request.getContextPath(), ExceptionMessage.INHERITANCE_EXCEPTION_LEVEL, LocalDateTime.now(), new HashMap<>()), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }
}
