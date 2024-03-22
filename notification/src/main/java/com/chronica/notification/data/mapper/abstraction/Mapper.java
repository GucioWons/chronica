package com.chronica.notification.data.mapper.abstraction;


import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public interface Mapper<DTO extends BaseDTO,Entity extends Notification>{
    DTO mappToDto(Entity entity);
    Entity mappToEntity(DTO dto);
}
