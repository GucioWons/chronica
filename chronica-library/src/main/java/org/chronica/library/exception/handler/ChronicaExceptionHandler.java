package org.chronica.library.exception.handler;

import org.chronica.library.exception.dto.ErrorDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.NoEntityException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@Order(1)
@ControllerAdvice
public class ChronicaExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NoEntityException.class })
    protected ResponseEntity<Object> handleNoEntityException(NoEntityException e, WebRequest request) {
        return handleExceptionInternal(e, buildNoEntityErrorDTO(e, request), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { ChronicaException.class })
    protected ResponseEntity<Object> handleChronicaException(ChronicaException e, WebRequest request) {
        return handleExceptionInternal(e, buildChronicaErrorDTO(e, request), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private ErrorDTO buildNoEntityErrorDTO(NoEntityException e, WebRequest request) {
        return new ErrorDTO(
                request.getContextPath(),
                e.getErrorMessage(),
                Map.of("className", e.getClassName(), "id", e.getId())
        );
    }

    private ErrorDTO buildChronicaErrorDTO(ChronicaException e, WebRequest request) {
        return new ErrorDTO(
                request.getContextPath(),
                e.getErrorMessage()
        );
    }
}
