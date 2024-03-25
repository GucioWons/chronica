package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.abstraction.NotificationDTO;
import com.chronica.notification.data.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public void mappToDto(NotificationDTO dto,Notification entity) {

        dto.setNotificationType(entity.getNotificationType());
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setViewAt(entity.getViewAt());
        dto.setReceiverId(entity.getReceiverId());
        dto.setDeprecated(entity.getDeprecated());
        dto.setSeen(entity.getSeen());

    }

    public void mappToEntity(Notification entity, NotificationDTO dto) {

        entity.setNotificationType(dto.getNotificationType());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setViewAt(dto.getViewAt());
        entity.setReceiverId(dto.getReceiverId());
        entity.setSeen(dto.getSeen());
    }
}