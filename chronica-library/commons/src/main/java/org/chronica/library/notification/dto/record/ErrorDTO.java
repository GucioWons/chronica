package org.chronica.library.notification.dto.record;

import java.time.LocalDateTime;

public record ErrorDTO(String apiPath,
                       String message,
                       LocalDateTime at) {}
