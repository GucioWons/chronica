package com.chronica.chain.mapper;

import com.chronica.chain.entity.Chain;
import org.chronica.library.exception.chain.NoChainException;
import com.chronica.chain.repository.ChainRepository;
import org.chronica.library.commons.dto.EntityDTO;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.chain.ChainDTO;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                ChainSelectMapper.class,
                ChildChainMapper.class,
                ChainRepository.class
        })
public abstract class ChainMapper implements BaseMapper<Chain, ChainDTO> {
    @Autowired
    private ChainRepository chainRepository;

    @Mapping(target = "baseChain", qualifiedByName = "toChainSelectDTO")
    public abstract ChainDTO mapToDTO(Chain entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "baseChain", expression = "java(getExistingChainOrThrow(dto.getBaseChain()))")
    @Mapping(target = "childChains", ignore = true)
    public abstract Chain mapToNewEntity(ChainDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "baseChain", expression = "java(getExistingChainOrThrow(dto.getBaseChain()))")
    @Mapping(target = "childChains", ignore = true)
    public abstract Chain mapToUpdateEntity(@MappingTarget Chain entity, ChainDTO dto);

    @AfterMapping
    public void setExistingChainList(@MappingTarget Chain entity, ChainDTO dto) {
        if (dto.getChildChains() == null) {
            return;
        }
        entity.getChildChains().clear();
        dto.getChildChains().forEach(childDTO -> entity.addChild(getExistingChainOrThrow(childDTO)));
    }

    public Chain getExistingChainOrThrow(EntityDTO dto) {
        if (dto == null) {
            return null;
        }
        return chainRepository
                .findByIdAndDeprecatedFalse(dto.getId())
                .orElseThrow(() -> new NoChainException("Cannot find Chain with id" + dto.getId()));
    }
}
