package com.chronica.project.util;

import org.chronica.library.exception.project.NoProjectException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NoProjectException.class })
    protected ResponseEntity<Object> toResponse(NoProjectException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
