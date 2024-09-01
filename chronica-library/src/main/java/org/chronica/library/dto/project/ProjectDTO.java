package org.chronica.library.dto.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.dto.EntityDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO extends EntityDTO {
    private String name;
    private Long groupId;
    private LocalDate createdDate;
    private LocalDateTime lastChangeDate;
    private boolean isDeprecated;
}
