package com.chronica.chain.mapper;

import com.chronica.chain.entity.Chain;
import org.chronica.library.dto.chain.BaseChainDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseChainMapper {
    BaseChainDTO mapBaseChainToDTO(Chain chain);
}
