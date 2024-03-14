package com.chronica.snap.api.snap.entity;

import com.chronica.snap.api.snap.enumerated.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Snap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer time;
    @Column(nullable = false)
    private Long chainId;
    @Column(nullable = false)
    private Activity activity;
    private String description;
    @Column(nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDate logDate;
    @Column(nullable = false)
    private boolean deprecated = false;
}
