package com.chronica.notification.data.mapper;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public NotificationDTO mappToDto(Notification entity) {
        NotificationDTO dto = new NotificationDTO();

        dto.setNotificationType(entity.getNotificationType());
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setViewAt(entity.getViewAt());
        dto.setReceiverId(entity.getReceiverId());
        dto.setDeprecated(entity.getDeprecated());
        dto.setSeen(entity.getSeen());

        return dto;
    }

    public Notification mappToEntity(NotificationDTO dto) {
        Notification entity = new Notification();

        entity.setNotificationType(dto.getNotificationType());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setViewAt(dto.getViewAt());
        entity.setReceiverId(dto.getReceiverId());
        entity.setDeprecated(dto.getDeprecated());
        entity.setSeen(dto.getSeen());

        return entity;
    }
}