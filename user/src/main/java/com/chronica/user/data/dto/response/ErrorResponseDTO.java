package com.chronica.user.data.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public record ErrorResponseDTO(String apiPath,
                               String message,
                               HttpStatus statusCode,
                               LocalDateTime at) {}
