package com.chronica.chain.mapper;

import com.chronica.chain.dto.ChainDTO;
import com.chronica.chain.entity.Chain;
import com.chronica.chain.exception.NoChainException;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChainMapper {
    private final BaseChainMapper baseChainMapper;
    private final ChildChainMapper childChainMapper;
    private final ChainRepository chainRepository;

    public Chain mapToEntity(ChainDTO dto) {
        Chain entity = new Chain();
        entity.setTitle(dto.getTitle());
        if (dto.getBaseChain() != null) {
            entity.setBaseChain(getExistingChain(dto.getBaseChain().getId()));
        }
        if (dto.getChildChains() != null) {
            entity.setChildChains(dto.getChildChains().stream().map(child -> getExistingChain(child.getId())).toList());
        }
        entity.setDescription(dto.getDescription());
        entity.setType(dto.getType());
        entity.setEstimation(dto.getEstimation());
        entity.setTimeLeft(dto.getTimeLeft());
        entity.setPoints(dto.getPoints());
        return entity;
    }

    public ChainDTO mapToDTO(Chain entity) {
        ChainDTO dto = new ChainDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setBaseChain(baseChainMapper.mapBaseChainToDTO(entity.getBaseChain()));
        dto.setChildChains(childChainMapper.mapChildChainsListToDTO(entity.getChildChains()));
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setEstimation(entity.getEstimation());
        dto.setTimeLeft(entity.getTimeLeft());
        dto.setPoints(entity.getPoints());
        return dto;
    }

    public Chain mapToUpdateEntity(Chain entity, ChainDTO dto) {
        if (dto.getTitle() != null) {
            entity.setTitle(dto.getTitle());
        }
        if (dto.getBaseChain() != null) {
            entity.setBaseChain(getExistingChain(dto.getBaseChain().getId()));
        } else {
            entity.setBaseChain(null);
        }
        if(dto.getChildChains() != null) {
            entity.getChildChains().clear();
            dto.getChildChains().forEach(chain -> entity.addChild(getExistingChain(chain.getId())));
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getType() != null) {
            entity.setType(dto.getType());
        }
        if (dto.getEstimation() != null) {
            entity.setEstimation(dto.getEstimation());
        }
        if (dto.getTimeLeft() != null) {
            entity.setTimeLeft(dto.getTimeLeft());
        }
        if (dto.getPoints() != null) {
            entity.setPoints(dto.getPoints());
        }
        return entity;
    }

    private Chain getExistingChain(Long id) {
        return chainRepository
                .findByIdAndDeprecatedFalse(id)
                .orElseThrow(() -> new NoChainException("Cannot find Chain with id" + id));
    }
}
