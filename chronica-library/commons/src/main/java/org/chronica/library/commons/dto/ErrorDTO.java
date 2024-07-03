package org.chronica.library.commons.dto;

import java.time.LocalDateTime;

public record ErrorDTO(String apiPath,
                       String message,
                       LocalDateTime at) {
}
