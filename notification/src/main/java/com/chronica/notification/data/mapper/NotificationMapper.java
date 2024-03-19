package com.chronica.notification.data.mapper;

import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class NotificationMapper {

    public NotificationDTO mappToDto(Notification entity) {
        return new NotificationDTO(
                entity.getNotificationType(),
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getViewAt(),
                entity.getReceiverId(),
                entity.getDeprecated(),
                entity.getSeen()
        );
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