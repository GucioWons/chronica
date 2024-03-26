package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ChainDTO {
    private Long id;
    private String title;
    private ChainDTO baseChain;
    private List<ChainDTO> childChains;
    private String description;
    private ChainType type;
    private BigDecimal estimation;
    private BigDecimal timeLeft;
    private Integer points;
    boolean deprecated;
}
