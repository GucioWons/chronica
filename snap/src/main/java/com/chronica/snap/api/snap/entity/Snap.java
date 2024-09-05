package com.chronica.snap.api.snap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.model.ChronicaEntity;
import org.chronica.library.enumerated.SnapActivity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Snap implements ChronicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer time;
    @Column(nullable = false)
    private Long chainId;
    @Column(nullable = false)
    private SnapActivity snapActivity;
    private String description;
    @Column(nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDate logDate;
    @Column(nullable = false)
    private boolean deprecated = false;
}
