package com.chronica.user.logic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.chronica.user.data.dto.response.ErrorResponseDTO;
import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest){
        final ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(exception.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        LOGGER.error(exception.getMessage() + " at " + errorResponseDto.at());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
