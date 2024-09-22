package org.chronica.library.exception.handler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
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

@Order(1)
@ControllerAdvice
public class JWTExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { ExpiredJwtException.class })
    protected ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException e, WebRequest request) {
        return handleExceptionInternal(e, buildExpiredJwtErrorDTO(request), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = { JwtException.class })
    protected ResponseEntity<Object> handleUnexpectedJwtException(JwtException e, WebRequest request) {
        return handleExceptionInternal(e, buildUnexpectedJwtErrorDTO(request), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    private ErrorDTO buildExpiredJwtErrorDTO(WebRequest request) {
        return new ErrorDTO(
                request.getContextPath(),
                ErrorMessage.EXPIRED_ACCESS_TOKEN_EXCEPTION
        );
    }

    private ErrorDTO buildUnexpectedJwtErrorDTO(WebRequest request) {
        return new ErrorDTO(
                request.getContextPath(),
                ErrorMessage.UNEXPECTED_JWT_EXCEPTION
        );
    }
}
