package com.chronica.chain.mapper;

import com.chronica.chain.entity.Chain;
import org.chronica.library.chain.dto.ChildChainDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildChainMapper {
    ChildChainDTO mapChildChainToDTO(Chain chain);
}
