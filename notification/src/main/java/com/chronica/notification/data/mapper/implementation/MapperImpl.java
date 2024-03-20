package com.chronica.notification.data.mapper.implementation;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.abstraction.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl<DTO extends BaseDTO, Entity extends Notification> extends Mapper<DTO,Entity> {


    @Override
    public DTO mappToDto(Entity entity) {
        return null;
    }

    @Override
    public Entity mappToEntity(DTO dto) {
        return null;
    }

}
