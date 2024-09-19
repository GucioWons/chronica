package org.chronica.library.exception;

import org.chronica.library.commons.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NoEntityException.class })
    protected ResponseEntity<Object> handleNoEntityException(NoEntityException e, WebRequest request) {
        return handleExceptionInternal(e, buildNoEntityErrorDTO(e, request), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private ErrorDTO buildNoEntityErrorDTO(NoEntityException e, WebRequest request) {
        return new ErrorDTO(
                request.getContextPath(),
                ExceptionMessage.NO_ENTITY_EXCEPTION,
                LocalDateTime.now(),
                Map.of("className", e.getClassName(), "id", e.getId()));
    }
}
