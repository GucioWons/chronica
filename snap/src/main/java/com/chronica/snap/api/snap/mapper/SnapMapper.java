package com.chronica.snap.api.snap.mapper;

import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.snap.dto.SnapDTO;
import com.chronica.snap.api.snap.entity.Snap;
import org.springframework.stereotype.Component;

@Component
public class SnapMapper implements BaseMapper<Snap, SnapDTO> {
    @Override
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

    @Override
    public Snap mapToNewEntity(SnapDTO dto) {
        Snap entity = new Snap();
        entity.setTime(dto.getTime());
        entity.setChainId(dto.getChainId());
        entity.setActivity(dto.getActivity());
        entity.setDescription(dto.getDescription());
        entity.setLogDate(dto.getLogDate());
        return entity;
    }

    @Override
    public Snap mapToUpdateEntity(Snap toUpdate, SnapDTO dto) {
        if (toUpdate.getTime() != null) {
            toUpdate.setTime(dto.getTime());
        }
        if (toUpdate.getChainId() != null) {
            toUpdate.setChainId(dto.getChainId());
        }
        if (toUpdate.getActivity() != null) {
            toUpdate.setActivity(dto.getActivity());
        }
        if(toUpdate.getDescription() != null) {
            toUpdate.setDescription(dto.getDescription());
        }
        if (toUpdate.getLogDate() != null) {
            toUpdate.setLogDate(dto.getLogDate());
        }
        return toUpdate;
    }
}
