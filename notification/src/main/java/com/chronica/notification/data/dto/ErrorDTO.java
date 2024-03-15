package com.chronica.notification.data.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDTO(String apiPath,
                       String message,
                       HttpStatus statusCode,
                       LocalDateTime at) {}
