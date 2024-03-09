package com.chronica.notification.logic;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.request.CreateNoticeRequestDto;
import com.chronica.notification.data.dto.request.QueryNoticeRequestDto;
import com.chronica.notification.data.dto.response.CreateNoticeResponseDto;
import com.chronica.notification.data.dto.response.DeprecateNoticeResponseDto;
import com.chronica.notification.data.dto.response.QueryNoticeResponseDto;
import com.chronica.notification.data.dto.response.ReadNoticeResponseDto;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.logic.notification.NotificationService;
import com.chronica.notification.logic.mapper.NoticeMapper;
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
public class NotificationApi {
    private final NotificationService<Notification> notificationService;

    @Transactional
    public ResponseEntity<CreateNoticeResponseDto> createNotice(CreateNoticeRequestDto request){
        final NotificationType notificationType = request.getNotificationType();
        final LocalDateTime createdAt = LocalDateTime.now();


        Map<NotificationType, Consumer<CreateNoticeRequestDto>> notificationMap = new HashMap<>();
        notificationMap.put(NotificationType.ALERT, this::createAndSaveAlert);
        notificationMap.put(NotificationType.INVITATION, this::createAndSaveInvitation);
        notificationMap.put(NotificationType.MESSAGE, this::createAndSaveMessage);


        notificationMap.getOrDefault(notificationType, requestDto -> {}).accept(request);

        final CreateNoticeResponseDto response = new CreateNoticeResponseDto(notificationType, createdAt);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    public ResponseEntity<ReadNoticeResponseDto> readNotice(Long id){
        final Notification notification = notificationService.findById(id);
        final ReadNoticeResponseDto response = NoticeMapper.readNoticeResponseMapper(notification);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<QueryNoticeResponseDto> queryAll(QueryNoticeRequestDto filter){
        final List notices = notificationService.findAll(filter);
        final QueryNoticeResponseDto response = NoticeMapper.queryNoticeResponseMapper(notices);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<DeprecateNoticeResponseDto> deleteNotice(Long id){
        final Notification notification = notificationService.findById(id);
        notification.setDeprecated(true);

        notificationService.save(notification);

        final DeprecateNoticeResponseDto response = new DeprecateNoticeResponseDto(id, true, LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    private void createAndSaveAlert(CreateNoticeRequestDto request){
        Alert alert = new Alert();

        populateAndSaveNotification(alert, request, NotificationType.ALERT);
        alert.setPriorityType(request.getAlert().priorityType());

        notificationService.save(alert);
    }

    private void createAndSaveInvitation(CreateNoticeRequestDto request){
        Invitation invitation = new Invitation();

        populateAndSaveNotification(invitation, request, NotificationType.INVITATION);
        invitation.setInvitationFromId(request.getInvitation().invitationFromId());
        invitation.setAccepted(false);

        notificationService.save(invitation);
    }

    private void createAndSaveMessage(CreateNoticeRequestDto request){
        Message message = new Message();

        populateAndSaveNotification(message, request, NotificationType.MESSAGE);
        message.setMessageFromId(request.getMessage().messageFromId());

        notificationService.save(message);
    }

    private void populateAndSaveNotification(Notification notification, CreateNoticeRequestDto request, NotificationType type){
        notification.setNotificationType(type);
        notification.setTitle(request.getNotification().title());
        notification.setContent(request.getNotification().content());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setReceiverId(request.getNotification().receiverId());
    }

}
