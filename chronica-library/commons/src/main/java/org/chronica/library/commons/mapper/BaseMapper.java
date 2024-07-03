package org.chronica.library.commons.mapper;

public interface BaseMapper<Entity, EntityDTO> {
    EntityDTO mapToDTO(Entity entity);

    Entity mapToNewEntity(EntityDTO entityDTO);

    Entity mapToUpdateEntity(Entity entity, EntityDTO entityDTO);
}
