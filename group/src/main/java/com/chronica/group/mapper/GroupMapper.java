package com.chronica.group.mapper;

import com.chronica.group.entity.Group;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.group.dto.GroupDTO;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements BaseMapper<Group, GroupDTO> {
    @Override
    public GroupDTO mapToDTO(Group entity) {
        GroupDTO dto = new GroupDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        dto.setOwnerId(entity.getOwnerId());
        dto.setDeprecated(entity.isDeprecated());
        return dto;
    }

    @Override
    public Group mapToNewEntity(GroupDTO dto) {
        Group entity = new Group();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setOwnerId(dto.getOwnerId());
        return entity;
    }

    @Override
    public Group mapToUpdateEntity(Group toUpdate, GroupDTO dto) {
        if (dto.getName() != null) {
            toUpdate.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            toUpdate.setDescription(dto.getDescription());
        }
        if(dto.getCategory() != null) {
            toUpdate.setCategory(dto.getCategory());
        }
        if(dto.getOwnerId() != null) {
            toUpdate.setOwnerId(dto.getOwnerId());
        }
        return toUpdate;
    }
}
