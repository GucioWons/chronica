package com.chronica.notification.logic;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.QueryNotificationDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.NotificationMapper;
import com.chronica.notification.logic.notification.NotificationService;
import com.chronica.notification.logic.util.PropertyTransfer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationMasterService {
    private final NotificationService<Notification> notificationService;
    private final NotificationMapper notificationMapper;

    @Transactional
    public ResponseEntity<NotificationDTO> createNotice(NotificationDTO request){
        final Notification notification = notificationMapper.mappToEntity(request);

        notificationService.save(notification);

        final NotificationDTO response = notificationMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Transactional
    public ResponseEntity<NotificationDTO> updateNotice(NotificationDTO request, Long id){
        final Notification notification = notificationService.findById(id);
        final Notification updated = notificationMapper.mappToEntity(request);

        PropertyTransfer.copyNonNullProperties(updated,notification);

        notificationService.save(notification);

        final NotificationDTO response = notificationMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<NotificationDTO> readNotice(Long id){
        final Notification notification = notificationService.findById(id);

        final NotificationDTO response = notificationMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<QueryNotificationDTO> queryAll(NotificationDTO filter){

        final List<Notification> notices = notificationService.findAll(filter);

        final QueryNotificationDTO response = new QueryNotificationDTO(notices.stream()
                .map(notificationMapper::mappToDto)
                .toList());

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
                .body("Deprecated notification id: " + id);
    }

}
