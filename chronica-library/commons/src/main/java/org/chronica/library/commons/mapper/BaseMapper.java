package org.chronica.library.commons.mapper;

public interface BaseMapper<Entity, EntityDTO> {
    EntityDTO mapToDTO(Entity entity);

    Entity mapToNewEntity(EntityDTO dto);

    Entity mapToUpdateEntity(Entity toUpdate, EntityDTO dto);
}
