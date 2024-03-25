package com.chronica.notification.data.mapper.abstraction;


import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public interface Mapper<DTO extends NotificationDTO,Entity extends Notification>{
    DTO mappToDto(Entity entity);
    Entity mappToEntity(DTO dto);
}
