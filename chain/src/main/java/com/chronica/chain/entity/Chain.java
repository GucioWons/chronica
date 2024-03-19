package com.chronica.chain.entity;

import com.chronica.chain.enumerated.ChainType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column(nullable = false)
    private ChainType type;
    @Column
    private BigDecimal estimation;
    @Column
    private BigDecimal timeLeft;
    @Column
    private Integer points;
    @Column(nullable = false)
    private boolean deprecated;
}
