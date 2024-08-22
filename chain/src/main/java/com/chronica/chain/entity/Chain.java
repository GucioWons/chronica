package com.chronica.chain.entity;

import org.chronica.library.chain.enumerated.ChainType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.model.ChronicaEntity;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "my_chain")
@Getter
@Setter
@NoArgsConstructor
public class Chain implements ChronicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="base_chain_id")
    private Chain baseChain;
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="base_chain_id")
    private List<Chain> childChains;
    @Column
    private String description;
    @Column(nullable = false)
    private ChainType chainType;
    @Column
    private BigDecimal estimation = BigDecimal.ZERO;
    @Column
    private BigDecimal timeLeft = BigDecimal.ZERO;
    @Column
    private Integer points = 0;
    @Column(nullable = false)
    private boolean deprecated;

    public void addChild(Chain child) {
        this.childChains.add(child);
    }
}
