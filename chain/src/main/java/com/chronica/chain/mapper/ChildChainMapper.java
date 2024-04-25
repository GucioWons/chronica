package com.chronica.chain.mapper;

import com.chronica.chain.dto.ChildChainDTO;
import com.chronica.chain.entity.Chain;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ChildChainMapper {
    public List<ChildChainDTO> mapChildChainsListToDTO(List<Chain> chains) {
        if (chains == null || chains.isEmpty()) {
            return Collections.emptyList();
        }
        return chains.stream()
                .map(this::mapChildChainToDTO)
                .toList();
    }

    private ChildChainDTO mapChildChainToDTO(Chain chain) {
        ChildChainDTO dto = new ChildChainDTO();
        dto.setId(chain.getId());
        dto.setTitle(chain.getTitle());
        dto.setType(chain.getType());
        dto.setChildChains(mapChildChainsListToDTO(chain.getChildChains()));
        return dto;
    }
}
