package com.chronica.notification.logic;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.QueryNotificationDTO;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.logic.notification.NotificationService;
import com.chronica.notification.logic.mapper.NoticeMapper;
import com.chronica.notification.logic.util.PropertyTransfer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class NotificationMasterService {
    private final NotificationService<Notification> notificationService;

    @Transactional
    public ResponseEntity<NotificationDTO> createNotice(NotificationDTO request){
        final NotificationType notificationType = request.notificationType();
        final LocalDateTime createdAt = LocalDateTime.now();


        Map<NotificationType, Consumer<NotificationDTO>> notificationMap = new HashMap<>();
        notificationMap.put(NotificationType.ALERT, this::createAndSaveAlert);
        notificationMap.put(NotificationType.INVITATION, this::createAndSaveInvitation);
        notificationMap.put(NotificationType.MESSAGE, this::createAndSaveMessage);


        notificationMap.getOrDefault(notificationType, requestDto -> {}).accept(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(request);
    }

    @Transactional
    public ResponseEntity<NotificationDTO> updateNotice(NotificationDTO request, Long id){
        final LocalDateTime updatedAt = LocalDateTime.now();
        Notification notification = notificationService.findById(id);

        PropertyTransfer.copyNonNullProperties(request,notification);

        notificationService.save(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(request);
    }

    public ResponseEntity<?> readNotice(Long id){
        final Notification notification = notificationService.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("its ok");
    }

    public ResponseEntity<QueryNotificationDTO> queryAll(NotificationDTO filter){
        final List notices = notificationService.findAll(filter);
        final QueryNotificationDTO response = NoticeMapper.queryNoticeResponseMapper(notices);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<String> deleteNotice(Long id){
        final Notification notification = notificationService.findById(id);

        notification.setDeprecated(true);

        notificationService.save(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deprecated notification id + " + id);
    }

    private void createAndSaveAlert(NotificationDTO request){
        Alert alert = new Alert();

        populateAndSaveNotification(alert, request, NotificationType.ALERT);
        alert.setPriorityType(request.priorityType());

        notificationService.save(alert);
    }

    private void createAndSaveInvitation(NotificationDTO request){
        Invitation invitation = new Invitation();

        populateAndSaveNotification(invitation, request, NotificationType.INVITATION);
        invitation.setInvitationFromId(request.invitationFromId());
        invitation.setAccepted(false);

        notificationService.save(invitation);
    }

    private void createAndSaveMessage(NotificationDTO request){
        Message message = new Message();

        populateAndSaveNotification(message, request, NotificationType.MESSAGE);
        message.setMessageFromId(request.messageFromId());

        notificationService.save(message);
    }

    private void populateAndSaveNotification(Notification notification, NotificationDTO request, NotificationType type){
        notification.setNotificationType(type);
        notification.setTitle(request.title());
        notification.setContent(request.content());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setReceiverId(request.receiverId());
    }

}
