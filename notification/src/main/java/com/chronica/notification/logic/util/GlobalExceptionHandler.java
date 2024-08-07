package com.chronica.notification.logic.util;

import lombok.extern.slf4j.Slf4j;
import org.chronica.library.commons.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest){
        ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now());

        LOGGER.error(exception.getMessage() + " at " + errorDTO.at());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
