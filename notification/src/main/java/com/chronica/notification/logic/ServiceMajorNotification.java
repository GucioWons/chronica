package com.chronica.notification.logic;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.record.PaginationAndSortDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.implementation.MapperImplementation;
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
    public ResponseEntity<BaseDTO> createNotification(BaseDTO request){

        Notification notification = mapperImplementation.mappToEntity(request);

        notificationService.save(notification);

        BaseDTO response = mapperImplementation.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Transactional
    public ResponseEntity<BaseDTO> updateNotification(BaseDTO request, Long id){
        Notification notification = notificationService.findById(id);

        Notification updated = mapperImplementation.mappToEntity(request);

        propertyTransfer.copyNonNullProperties(updated,notification);

        notificationService.save(notification);

        BaseDTO response = mapperImplementation.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<BaseDTO> readNotification(Long id){
        Notification notification = notificationService.findById(id);

        BaseDTO response = mapperImplementation.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<List<BaseDTO>> getAllNotifications(PaginationAndSortDTO request){
        Page<Notification> notices = notificationService.findAll(request);

        List<BaseDTO> response = notices.stream()
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
