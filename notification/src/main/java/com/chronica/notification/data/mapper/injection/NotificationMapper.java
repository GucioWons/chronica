package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.integrant.BaseDataDTO;
import com.chronica.notification.data.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public BaseDataDTO mappToDto(Notification entity) {
        BaseDataDTO dto = new BaseDataDTO();

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

    public void mappToEntity(Notification entity, BaseDataDTO dto) {

        entity.setNotificationType(dto.getNotificationType());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setViewAt(dto.getViewAt());
        entity.setReceiverId(dto.getReceiverId());
        entity.setSeen(dto.getSeen());
    }
}