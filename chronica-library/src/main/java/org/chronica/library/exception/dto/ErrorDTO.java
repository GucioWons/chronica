package org.chronica.library.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorDTO {
    private final String apiPath;
    private final ErrorMessage message;
    private final LocalDateTime at = LocalDateTime.now();
    private final Map<String, Object> properties;

    public ErrorDTO(String apiPath, ErrorMessage message) {
        this.apiPath = apiPath;
        this.message = message;
        this.properties = Collections.emptyMap();
    }
}
