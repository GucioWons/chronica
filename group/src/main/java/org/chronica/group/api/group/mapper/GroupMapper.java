package org.chronica.group.api.group.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.group.api.group.dto.GroupDTO;
import org.chronica.group.api.group.entity.Group;

@ApplicationScoped
public class GroupMapper {
    public GroupDTO mapToDTO(Group entity) {
        GroupDTO dto = new GroupDTO();
        dto.setId(entity.id);
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        dto.setOwnerId(entity.getOwnerId());
        dto.setDeprecated(entity.isDeprecated());
        return dto;
    }

    public Group mapToEntity(GroupDTO dto) {
        Group entity = new Group();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory());
        entity.setOwnerId(dto.getOwnerId());
        return entity;
    }

    public Group mapToUpdateEntity(Group entity, GroupDTO dto) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if(dto.getCategory() != null) {
            entity.setCategory(dto.getCategory());
        }
        if(dto.getOwnerId() != null) {
            entity.setOwnerId(dto.getOwnerId());
        }
        return entity;
    }
}
