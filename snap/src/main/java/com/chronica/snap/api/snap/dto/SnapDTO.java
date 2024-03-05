package com.chronica.snap.api.snap.dto;

import com.chronica.snap.api.snap.entity.Activity;

import java.time.LocalDateTime;
import java.util.Date;

public record SnapDTO(Long id,
                      Integer time,
                      Long chainId,
                      Activity activity,
                      String description,
                      LocalDateTime creationDate,
                      Date logDate,
                      boolean deprecated) {
}
