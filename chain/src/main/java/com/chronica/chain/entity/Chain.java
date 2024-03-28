package com.chronica.chain.entity;

import com.chronica.chain.enumerated.ChainType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "chain_sraka")
@Getter
@Setter
@NoArgsConstructor
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name="base_chain_id")
    private Chain baseChain;
    @OneToMany(mappedBy="baseChain")
    private List<Chain> childChains;
    @Column
    private String description;
    @Column(nullable = false)
    private ChainType type;
    @Column
    private BigDecimal estimation = BigDecimal.ZERO;
    @Column
    private BigDecimal timeLeft = BigDecimal.ZERO;
    @Column
    private Integer points = 0;
    @Column(nullable = false)
    private boolean deprecated;
}
