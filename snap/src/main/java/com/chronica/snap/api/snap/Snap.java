package com.chronica.snap.api.snap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Snap {
    private Long id;
    private Integer time;
    private Long chainId;
    private Object activity;
    private String description;
    private LocalDateTime creationDate;
    private Date logDate;
    private boolean deprecated;
}
