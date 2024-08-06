package com.chronica.chain.mapper;

import com.chronica.chain.entity.Chain;
import com.chronica.chain.exception.NoChainException;
import com.chronica.chain.repository.ChainRepository;
import org.chronica.library.chain.dto.ChainDTO;
import org.chronica.library.chain.dto.ChildChainDTO;
import org.chronica.library.commons.dto.EntityDTO;
import org.chronica.library.commons.mapper.BaseMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
                BaseChainMapper.class,
                ChildChainMapper.class,
                ChainRepository.class
        })
public abstract class ChainMapper implements BaseMapper<Chain, ChainDTO> {
    @Autowired
    private ChainRepository chainRepository;

    public abstract ChainDTO mapToDTO(Chain entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "baseChain", expression = "java(getExistingChainOrThrow(dto.getBaseChain()))")
    @Mapping(target = "childChains", expression = "java(getExistingChainList(dto.getChildChains()))")
    public abstract Chain mapToNewEntity(ChainDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "baseChain", expression = "java(getExistingChainOrThrow(dto.getBaseChain()))")
    @Mapping(target = "childChains", expression = "java(getExistingChainList(dto.getChildChains()))")
    public abstract Chain mapToUpdateEntity(@MappingTarget Chain entity, ChainDTO dto);

    public List<Chain> getExistingChainList(List<ChildChainDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(this::getExistingChainOrThrow)
                .toList();
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
