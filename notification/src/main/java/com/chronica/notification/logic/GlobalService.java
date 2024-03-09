package com.chronica.notification.logic;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.dto.request.CreateNoticeRequestDto;
import com.chronica.notification.data.dto.response.CreateNoticeResponseDto;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GlobalService {
    private final NotificationService notificationService;

    public GlobalService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public ResponseEntity<CreateNoticeResponseDto> createNotice(CreateNoticeRequestDto request){
        final NotificationType notificationType = request.getNotificationType();
        final String title = request.getNotification().title();
        final String content = request.getNotification().content();
        final LocalDateTime createdAt = LocalDateTime.now();
        final Long receiverId = request.getNotification().receiverId();

        CreateNoticeResponseDto response;

        if(notificationType == NotificationType.ALERT){
            final PriorityType priorityType = request.getAlert().priorityType();
            final Alert alert = new Alert();

            alert.setTitle(title);
            alert.setContent(content);
            alert.setCreatedAt(createdAt);
            alert.setReceiverId(receiverId);
            alert.setPriorityType(priorityType);

            notificationService.save(alert);

        }

        if(notificationType == NotificationType.INVITATION){
            final Long broadcasterId = request.getInvitation().broadcasterId();
            final Invitation invitation = new Invitation();

            invitation.setTitle(title);
            invitation.setContent(content);
            invitation.setCreatedAt(createdAt);
            invitation.setReceiverId(receiverId);
            invitation.setBroadcasterId(broadcasterId);
            invitation.setAccepted(false);

            notificationService.save(invitation);
        }

        if(notificationType == NotificationType.MESSAGE){
            final Long broadcasterId = request.getMessage().broadcasterId();
            final Message message = new Message();

            message.setTitle(title);
            message.setContent(content);
            message.setCreatedAt(createdAt);
            message.setReceiverId(receiverId);
            message.setBroadcasterId(broadcasterId);


            notificationService.save(message);
        }

        response = new CreateNoticeResponseDto(notificationType,createdAt);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
