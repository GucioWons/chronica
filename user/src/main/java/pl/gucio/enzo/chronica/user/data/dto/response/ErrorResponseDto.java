package pl.gucio.enzo.chronica.user.data.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public record ErrorResponseDto(String apiPath,
                               String message,
                               HttpStatus statusCode,
                               LocalDateTime at) {}
