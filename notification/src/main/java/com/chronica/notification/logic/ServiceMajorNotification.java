package com.chronica.notification.logic;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.record.PaginationAndSortDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.MapperImplementation;
import com.chronica.notification.logic.notification.NotificationService;
import com.chronica.notification.logic.util.PropertyTransfer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceMajorNotification {

    private final NotificationService<Notification> notificationService;
    private final MapperImplementation mapperImplementation;
    private final PropertyTransfer propertyTransfer;

    @Transactional
    public ResponseEntity<NotificationDTO> createNotification(NotificationDTO request){

        Notification notification = mapperImplementation.mappToEntity(request);

        notificationService.save(notification);

        NotificationDTO response = mapperImplementation.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Transactional
    public ResponseEntity<NotificationDTO> updateNotification(NotificationDTO request, Long id){
        Notification notification = notificationService.findById(id);

        Notification updated = mapperImplementation.mappToEntity(request);

        propertyTransfer.copyNonNullProperties(updated,notification);

        notificationService.save(notification);

        NotificationDTO response = mapperImplementation.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<NotificationDTO> readNotification(Long id){
        Notification notification = notificationService.findById(id);

        NotificationDTO response = mapperImplementation.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<List<NotificationDTO>> getAllNotifications(PaginationAndSortDTO request){
        Page<Notification> notices = notificationService.findAll(request);

        List<NotificationDTO> response = notices.stream()
                .map(mapperImplementation::mappToDto)
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<String> deleteNotification(Long id){
        Notification notification = notificationService.findById(id);

        notification.setDeprecated(true);

        notificationService.save(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deprecated notification id: " + id);
    }

}
