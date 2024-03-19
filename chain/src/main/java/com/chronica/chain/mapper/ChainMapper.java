package com.chronica.chain.mapper;

import com.chronica.chain.dto.ChainDTO;
import com.chronica.chain.entity.Chain;
import org.springframework.stereotype.Component;

@Component
public class ChainMapper {
    public Chain mapToEntity(ChainDTO dto) {
        Chain entity = new Chain();
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setType(dto.type());
        entity.setEstimation(dto.estimation());
        entity.setTimeLeft(dto.timeLeft());
        entity.setPoints(dto.points());
        entity.setDeprecated(dto.deprecated());
        return entity;
    }

    public ChainDTO mapToDTO(Chain entity) {
        return new ChainDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getType(),
                entity.getEstimation(),
                entity.getTimeLeft(),
                entity.getPoints(),
                entity.isDeprecated()
        );
    }
}
