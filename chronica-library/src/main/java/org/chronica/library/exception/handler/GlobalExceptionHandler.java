package org.chronica.library.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.chronica.library.exception.dto.ErrorDTO;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Order(2)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleUnexpectedException(Exception e, WebRequest request) {
        log.error("An unexpected error of type " + e.getClass().getName() + " occured.", e);
        return handleExceptionInternal(e, buildUnexpectedErrorDTO(request), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ErrorDTO buildUnexpectedErrorDTO(WebRequest request) {
        return new ErrorDTO(
                request.getContextPath(),
                ErrorMessage.UNEXPECTED_EXCEPTION
        );
    }
}
