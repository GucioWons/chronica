package org.chronica.project.data.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record ProjectDTO(
        Long id,
        String name,
        Long groupId,
        LocalDate createdDate,
        LocalDateTime lastChangesDate,
        boolean isDeprecated) {
}
