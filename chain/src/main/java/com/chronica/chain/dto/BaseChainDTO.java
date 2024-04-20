package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.dto.EntityDTO;

@Getter
@Setter
@NoArgsConstructor
public class BaseChainDTO extends EntityDTO {
    private String title;
    private ChainType type;
}
