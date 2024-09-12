package org.chronica.library.dto.chain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.enumerated.ChainType;
import org.chronica.library.commons.dto.EntityDTO;

@Getter
@Setter
@NoArgsConstructor
public class BaseChainDTO extends EntityDTO {
    private String title;
    private ChainType type;
}
