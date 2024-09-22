package org.chronica.library.dto.chain;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.chronica.library.enumerated.ChainType;
import org.chronica.library.dto.EntityDTO;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ChainDTO extends EntityDTO {
    private String title;
    @Nullable
    private ChainSelectDTO baseChain;
    @Nullable
    private List<ChildChainDTO> childChains;
    private String description;
    private ChainType type;
    @Nullable
    private BigDecimal estimation;
    @Nullable
    private BigDecimal timeLeft;
    @Nullable
    private Integer points;
}
