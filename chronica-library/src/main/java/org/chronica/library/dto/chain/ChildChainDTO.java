package org.chronica.library.dto.chain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.enumerated.ChainType;
import org.chronica.library.dto.EntityDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChildChainDTO extends ChainSelectDTO {
    private List<ChildChainDTO> childChains;
}
