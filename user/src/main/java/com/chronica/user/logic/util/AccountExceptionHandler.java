package com.chronica.user.logic.util;

import lombok.extern.slf4j.Slf4j;
import org.chronica.library.exception.user.NoAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.chronica.library.commons.dto.ErrorDTO;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class AccountExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountExceptionHandler.class);

    @ExceptionHandler(NoAccountException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(NoAccountException exception, WebRequest webRequest) {
        ErrorDTO errorDto = new ErrorDTO(exception.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now());
        LOGGER.error("{} at {}", exception.getMessage(), errorDto.at());

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}