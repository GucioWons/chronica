package com.chronica.chain.mapper;

import org.chronica.library.chain.dto.BaseChainDTO;
import com.chronica.chain.entity.Chain;
import org.springframework.stereotype.Component;

@Component
public class BaseChainMapper {
    public BaseChainDTO mapBaseChainToDTO(Chain chain) {
        if (chain == null) {
            return null;
        }
        BaseChainDTO dto = new BaseChainDTO();
        dto.setId(chain.getId());
        dto.setTitle(chain.getTitle());
        dto.setType(chain.getType());
        return dto;
    }
}
