package org.chronica.library.commons.dto;

import org.chronica.library.exception.ExceptionMessage;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorDTO(String apiPath,
                       ExceptionMessage message,
                       LocalDateTime at,
                       Map<String, Object> data) {
}
