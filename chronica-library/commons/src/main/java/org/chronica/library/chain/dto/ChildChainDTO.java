package org.chronica.library.chain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.chain.enumerated.ChainType;
import org.chronica.library.dto.EntityDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChildChainDTO extends EntityDTO {
    private String title;
    private ChainType type;
    private List<ChildChainDTO> childChains;
}
