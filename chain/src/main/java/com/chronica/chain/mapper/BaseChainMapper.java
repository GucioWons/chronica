package com.chronica.chain.mapper;

import com.chronica.chain.dto.BaseChainDTO;
import com.chronica.chain.entity.Chain;
import org.springframework.stereotype.Component;

@Component
public class BaseChainMapper {
    public BaseChainDTO mapBaseChainToDTO(Chain chain) {
        if (chain == null) {
            return null;
        }
        return new BaseChainDTO(
                chain.getId(),
                chain.getTitle(),
                chain.getType());
    }
}
