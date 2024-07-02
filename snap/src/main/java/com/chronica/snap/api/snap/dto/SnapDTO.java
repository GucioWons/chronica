package com.chronica.snap.api.snap.dto;

import com.chronica.snap.api.snap.enumerated.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;

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
