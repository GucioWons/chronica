package com.chronica.user.data.mapper;

public interface Mapper<Entity,DTO>{
    DTO mappToDTO(Entity entity);
    Entity mappToEntity(DTO dto);
}
