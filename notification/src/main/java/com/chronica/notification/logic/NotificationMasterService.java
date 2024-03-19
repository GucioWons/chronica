package com.chronica.notification.logic;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.PaginationAndSortDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.NotificationMapper;
import com.chronica.notification.logic.notification.NotificationService;
import com.chronica.notification.logic.util.PropertyTransfer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationMasterService {
    private final NotificationService<Notification> notificationService;
    private final NotificationMapper notificationMapper;
    private final PropertyTransfer propertyTransfer;

    @Transactional
    public ResponseEntity<NotificationDTO> createNotice(NotificationDTO request){
        Notification notification = notificationMapper.mappToEntity(request);

        notificationService.save(notification);

        NotificationDTO response = notificationMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Transactional
    public ResponseEntity<NotificationDTO> updateNotice(NotificationDTO request, Long id){
        Notification notification = notificationService.findById(id);
        Notification updated = notificationMapper.mappToEntity(request);

        propertyTransfer.copyNonNullProperties(updated,notification);

        notificationService.save(notification);

        NotificationDTO response = notificationMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<NotificationDTO> readNotice(Long id){
        Notification notification = notificationService.findById(id);
        NotificationDTO response = notificationMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<List<NotificationDTO>> queryAll(PaginationAndSortDTO request){
        Page<Notification> notices = notificationService.findAll(request);

        List<NotificationDTO> response = notices.stream()
                .map(notificationMapper::mappToDto)
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<String> deleteNotice(Long id){
        Notification notification = notificationService.findById(id);

        notification.setDeprecated(true);

        notificationService.save(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Deprecated notification id: " + id);
    }
}
