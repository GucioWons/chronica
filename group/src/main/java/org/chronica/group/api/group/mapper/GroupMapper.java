package org.chronica.group.api.group.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.group.api.group.dto.GroupDTO;
import org.chronica.group.api.group.entity.Group;

@ApplicationScoped
public class GroupMapper {
    public GroupDTO mapToDTO(Group entity) {
        return new GroupDTO(
                entity.id,
                entity.getName(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getOwnerId(),
                entity.isDeprecated());
    }

    public Group mapToEntity(GroupDTO dto) {
        Group entity = new Group();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setCategory(dto.category());
        entity.setOwnerId(dto.ownerId());
        return entity;
    }

    public Group mapToUpdateEntity(Group entity, GroupDTO dto) {
        if (dto.name() != null) {
            entity.setName(dto.name());
        }
        if (dto.description() != null) {
            entity.setDescription(dto.description());
        }
        if(dto.category() != null) {
            entity.setCategory(dto.category());
        }
        if(dto.ownerId() != null) {
            entity.setOwnerId(dto.ownerId());
        }
        return entity;
    }
}
