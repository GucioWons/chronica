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
        Long messageFromId  = null;
        Long invitationFromId = null;
        Boolean isAccepted = null;
        LocalDateTime acceptedAt = null;
        String priorityType = null;

        if(entity instanceof Alert){
            priorityType = String.valueOf(((Alert) entity).getPriorityType());
        }

        if(entity instanceof Message){
            messageFromId =  ((Message) entity).getMessageFromId();
        }

        if(entity instanceof Invitation){
            invitationFromId =  ((Invitation) entity).getInvitationFromId();
            isAccepted =  ((Invitation) entity).getAccepted();
            acceptedAt =((Invitation) entity).getAcceptedAt();
        }

       return new NotificationDTO(
                entity.getNotificationType(),
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getOpenAt(),
                entity.getReceiverId(),
                entity.getDeprecated(),
                messageFromId,
                invitationFromId,
                isAccepted,
                acceptedAt,
                priorityType
        );
    }

    public Notification mappToEntity(NotificationDTO dto) {
        Notification entity;

        if(dto.priorityType() != null){
            entity = new Alert();
            ((Alert) entity).setPriorityType(PriorityType.valueOf(dto.priorityType()));
        }

        if(dto.messageFromId() != null){
            entity = new Message();
            ((Message) entity).setMessageFromId(dto.messageFromId());
        }

        else {
            entity = new Invitation();
            ((Invitation) entity).setInvitationFromId(dto.invitationFromId());
            ((Invitation) entity).setAccepted(dto.accepted());
            ((Invitation) entity).setAcceptedAt(dto.acceptedAt());
        }

        entity.setId(dto.id());
        entity.setNotificationType(dto.notificationType());
        entity.setTitle(dto.title());
        entity.setContent(dto.content());
        entity.setCreatedAt(dto.createdAt());
        entity.setOpenAt(dto.openAt());
        entity.setReceiverId(dto.receiverId());
        entity.setDeprecated(dto.deprecated());

        return entity;
    }

}