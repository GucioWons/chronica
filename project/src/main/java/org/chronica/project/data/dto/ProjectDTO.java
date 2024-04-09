package org.chronica.project.data.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProjectDTO(
        Long id,
        String name,
        Long groupId,
        LocalDate createdDate,
        LocalDateTime lastChangeDate,
        boolean isDeprecated) {
}
