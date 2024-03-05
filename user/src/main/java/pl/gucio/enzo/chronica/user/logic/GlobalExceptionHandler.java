package pl.gucio.enzo.chronica.user.logic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pl.gucio.enzo.chronica.user.data.dto.ErrorResponseDto;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponseDto> handleSQLException(SQLException exception, WebRequest webRequest){
        final ErrorResponseDto errorResponseBuilder = ErrorResponseDto.builder()
                .message("User already exist")
                .apiPath(webRequest.getDescription(false))
                .statusCode(HttpStatus.FOUND)
                .at(LocalDateTime.now()).build();

        LOGGER.error(exception.getMessage() + " at " + errorResponseBuilder.getAt());

        return new ResponseEntity<>(errorResponseBuilder, HttpStatus.FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest){
        final ErrorResponseDto errorResponseBuilder = ErrorResponseDto.builder()
                .message(exception.getMessage())
                .apiPath(webRequest.getDescription(false))
                .statusCode(HttpStatus.BAD_REQUEST)
                .at(LocalDateTime.now()).build();

        LOGGER.error(exception.getMessage() + " at " + errorResponseBuilder.getAt());

        return new ResponseEntity<>(errorResponseBuilder, HttpStatus.BAD_REQUEST);
    }
}
