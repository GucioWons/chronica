package com.chronica.chain.mapper;

import com.chronica.chain.dto.ChainDTO;
import com.chronica.chain.entity.Chain;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChainMapper {
    private final ChainRepository chainRepository;

    public Chain mapToEntity(ChainDTO dto) {
        Chain entity = new Chain();
        entity.setTitle(dto.getTitle());
        entity.setBaseChain(getExistingChain(dto.getBaseChain().getId()));
        entity.setChildChains(getExistingChainList(dto.getChildChains()));
        entity.setDescription(dto.getDescription());
        entity.setType(dto.getType());
        entity.setEstimation(dto.getEstimation());
        entity.setTimeLeft(dto.getTimeLeft());
        entity.setPoints(dto.getPoints());
        entity.setDeprecated(dto.isDeprecated());
        return entity;
    }

    public ChainDTO mapToDTO(Chain entity) {
        return new ChainDTO(
                entity.getId(),
                entity.getTitle(),
                mapExistingChainToDTO(entity.getBaseChain()),
                mapExistingChainListToDTO(entity.getChildChains()),
                entity.getDescription(),
                entity.getType(),
                entity.getEstimation(),
                entity.getTimeLeft(),
                entity.getPoints(),
                entity.isDeprecated()
        );
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
        if (dto.getChildChains() != null) {
            entity.setChildChains(getExistingChainList(dto.getChildChains()));
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

    public List<ChainDTO> mapExistingChainListToDTO(List<Chain> chains) {
        return chains.stream()
                .map(this::mapToDTO)
                .toList();
    }

    public ChainDTO mapExistingChainToDTO(Chain chain) {
        return mapToDTO(chain);
    }

    public List<Chain> getExistingChainList(List<ChainDTO> chains) {
        return chains.stream()
                .map(chain -> getExistingChain(chain.getId()))
                .toList();
    }

    public Chain getExistingChain(Long chainId) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
