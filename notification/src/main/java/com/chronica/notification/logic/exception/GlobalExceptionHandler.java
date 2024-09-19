package com.chronica.notification.logic.exception;

import lombok.extern.slf4j.Slf4j;
import org.chronica.library.commons.dto.ErrorDTO;
import org.chronica.library.exception.ExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest){
        ErrorDTO errorDTO = new ErrorDTO(webRequest.getContextPath(),
                ExceptionMessage.WRONG_MAPPER,
                LocalDateTime.now(),
                new HashMap<>());

        LOGGER.error("{} at {}", exception.getMessage(), errorDTO.at());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
