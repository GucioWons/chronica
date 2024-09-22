package org.chronica.library.dto.snap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;
import org.chronica.library.enumerated.SnapActivity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SnapDTO extends EntityDTO {
    private Integer time;
    private Long chainId;
    private SnapActivity snapActivity;
    private String description;
    private LocalDateTime creationDate;
    private LocalDate logDate;
}
