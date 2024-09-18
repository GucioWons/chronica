package com.chronica.chain.mapper;

import com.chronica.chain.entity.Chain;
import org.chronica.library.dto.chain.ChildChainDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                ChainSelectMapper.class,
        })
public interface ChildChainMapper {
    ChildChainDTO mapToChildChainDTO(Chain chain);
}
