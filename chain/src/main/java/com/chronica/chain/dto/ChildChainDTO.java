package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.dto.EntityDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChildChainDTO extends EntityDTO {
    private String title;
    private ChainType type;
    private List<ChildChainDTO> childChains;
}
