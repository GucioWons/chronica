package com.chronica.snap.api.snap.dto;

import com.chronica.snap.api.snap.enumerated.Activity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SnapDTO(Long id,
                      Integer time,
                      Long chainId,
                      Activity activity,
                      String description,
                      LocalDateTime creationDate,
                      LocalDate logDate,
                      boolean deprecated) {
}
