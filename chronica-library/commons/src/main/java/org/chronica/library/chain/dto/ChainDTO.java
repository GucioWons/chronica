package org.chronica.library.chain.dto;

import lombok.Getter;
import lombok.Setter;
import org.chronica.library.chain.enumerated.ChainType;
import org.chronica.library.commons.dto.EntityDTO;

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
