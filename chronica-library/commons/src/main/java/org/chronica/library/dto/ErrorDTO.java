package org.chronica.library.dto;

import java.time.LocalDateTime;

public record ErrorDTO(String apiPath,
                       String message,
                       LocalDateTime at) {
}
