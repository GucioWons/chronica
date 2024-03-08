package pl.gucio.enzo.chronica.user.logic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pl.gucio.enzo.chronica.user.data.dto.response.ErrorResponseDto;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponseDto> handleSQLException(SQLException exception, WebRequest webRequest){
        final ErrorResponseDto errorResponseDto = new ErrorResponseDto("user already exist",
                                                  webRequest.getDescription(false),
                                                  HttpStatus.BAD_REQUEST,
                                                  LocalDateTime.now());
        LOGGER.error(exception.getMessage() + " at " + errorResponseDto.at());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest){
        final ErrorResponseDto errorResponseDto = new ErrorResponseDto(exception.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        LOGGER.error(exception.getMessage() + " at " + errorResponseDto.at());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
