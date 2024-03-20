package com.chronica.notification.data.mapper.implementation;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.entity.Notification;


public class MapperModelImpl<DTO extends BaseDTO,ENTITY extends Notification>  {
    private final MapperImpl<DTO,ENTITY> mapper;
    public MapperModelImpl(MapperImpl<DTO,ENTITY> mapper) {
        this.mapper = mapper;
    }


    public DTO mappToDto(ENTITY entity) {
        return this.mapper.mappToDto(entity);
    }


    public ENTITY mappToEntity(DTO dto) {
        return this.mapper.mappToEntity(dto);
    }

}
