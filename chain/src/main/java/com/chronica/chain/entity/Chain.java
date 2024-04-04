package com.chronica.chain.entity;

import com.chronica.chain.enumerated.ChainType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "chain_sraka")
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="base_chain_id")
    private Chain baseChain;
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="base_chain_id")
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

    public Chain() {
        childChains = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Chain getBaseChain() {
        return baseChain;
    }

    public void setBaseChain(Chain baseChain) {
        this.baseChain = baseChain;
    }

    public List<Chain> getChildChains() {
        return childChains;
    }

    public void setChildChains(List<Chain> childChains) {
        this.childChains = childChains;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChainType getType() {
        return type;
    }

    public void setType(ChainType type) {
        this.type = type;
    }

    public BigDecimal getEstimation() {
        return estimation;
    }

    public void setEstimation(BigDecimal estimation) {
        this.estimation = estimation;
    }

    public BigDecimal getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(BigDecimal timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }

    public void removeChild(Chain child) {
        this.childChains.remove(child);
    }

    public void addChild(Chain child) {
        this.childChains.add(child);
    }
}
