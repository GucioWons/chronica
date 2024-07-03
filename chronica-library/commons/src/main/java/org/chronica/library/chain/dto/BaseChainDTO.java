package org.chronica.library.chain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.chain.enumerated.ChainType;
import org.chronica.library.commons.dto.EntityDTO;

@Getter
@Setter
@NoArgsConstructor
public class BaseChainDTO extends EntityDTO {
    private String title;
    private ChainType type;
}
