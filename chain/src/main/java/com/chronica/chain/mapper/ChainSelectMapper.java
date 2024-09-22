package com.chronica.chain.mapper;

import com.chronica.chain.entity.Chain;
import org.chronica.library.dto.chain.ChainSelectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ChainSelectMapper {
    @Named("toChainSelectDTO")
    ChainSelectDTO mapToChainSelectDTO(Chain chain);
}
