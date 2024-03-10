package com.chronica.snap.api.snap.mapper;

import com.chronica.snap.api.snap.dto.SnapDTO;
import com.chronica.snap.api.snap.entity.Snap;
import org.springframework.stereotype.Component;

@Component
public class SnapMapper {
    public Snap mapToEntity(SnapDTO dto) {
        Snap entity = new Snap();
        entity.setTime(dto.time());
        entity.setChainId(dto.chainId());
        entity.setActivity(dto.activity());
        entity.setDescription(dto.description());
        entity.setCreationDate(dto.creationDate());
        entity.setLogDate(dto.logDate());
        entity.setDeprecated(dto.deprecated());
        return entity;
    }

    public SnapDTO mapToDTO(Snap entity) {
        return new SnapDTO(
                entity.getId(),
                entity.getTime(),
                entity.getChainId(),
                entity.getActivity(),
                entity.getDescription(),
                entity.getCreationDate(),
                entity.getLogDate(),
                entity.isDeprecated());
    }
}
