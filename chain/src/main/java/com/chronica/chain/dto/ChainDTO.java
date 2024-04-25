package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;
import lombok.Getter;
import lombok.Setter;
import org.chronica.dto.EntityDTO;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ChainDTO extends EntityDTO {
    private String title;
    private BaseChainDTO baseChain;
    private List<ChildChainDTO> childChains;
    private String description;
    private ChainType type;
    private BigDecimal estimation;
    private BigDecimal timeLeft;
    private Integer points;
}
