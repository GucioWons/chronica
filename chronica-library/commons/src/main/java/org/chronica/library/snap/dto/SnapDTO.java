package org.chronica.library.snap.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.dto.EntityDTO;
import org.chronica.library.snap.enumerated.Activity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SnapDTO extends EntityDTO {
    private Integer time;
    private Long chainId;
    private Activity activity;
    private String description;
    private LocalDateTime creationDate;
    private LocalDate logDate;
    private boolean deprecated;
}
