package com.chronica.snap.api.snap.mapper;

import org.chronica.library.snap.dto.SnapDTO;
import com.chronica.snap.api.snap.entity.Snap;
import org.springframework.stereotype.Component;

@Component
public class SnapMapper {
    public Snap mapToEntity(SnapDTO dto) {
        Snap entity = new Snap();
        entity.setTime(dto.getTime());
        entity.setChainId(dto.getChainId());
        entity.setActivity(dto.getActivity());
        entity.setDescription(dto.getDescription());
        entity.setLogDate(dto.getLogDate());
        return entity;
    }

    public SnapDTO mapToDTO(Snap entity) {
        SnapDTO dto = new SnapDTO();
        dto.setId(entity.getId());
        dto.setTime(entity.getTime());
        dto.setChainId(entity.getChainId());
        dto.setActivity(entity.getActivity());
        dto.setDescription(entity.getDescription());
        dto.setCreationDate(entity.getCreationDate());
        dto.setLogDate(entity.getLogDate());
        dto.setDeprecated(entity.isDeprecated());
        return dto;
    }
}
