package com.chronica.notification.data.mapper.abstraction;




public abstract class Mapper<DTO,Entity>{
    public abstract DTO mappToDto(Entity entity);
    public abstract Entity mappToEntity(DTO dto);
}
