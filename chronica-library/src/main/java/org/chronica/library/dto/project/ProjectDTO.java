package org.chronica.library.dto.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.chronica.library.commons.dto.EntityDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO extends EntityDTO {
    private String name;
    private Long groupId;
    @Nullable
    private LocalDateTime createdDate;
    @Nullable
    private LocalDateTime lastChangeDate;
}
