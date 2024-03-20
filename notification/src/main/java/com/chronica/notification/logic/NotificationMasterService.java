package com.chronica.notification.logic;

import com.chronica.notification.data.dto.*;
import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.record.PaginationAndSortDTO;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.AlertMapper;
import com.chronica.notification.data.mapper.InvitationMapper;
import com.chronica.notification.data.mapper.MessageMapper;
import com.chronica.notification.data.mapper.implementation.MapperModelImpl;
import com.chronica.notification.data.mapper.implementation.MapperImpl;
import com.chronica.notification.data.mapper.injection.NotificationMapper;
import com.chronica.notification.logic.notification.NotificationService;
import com.chronica.notification.logic.util.PropertyTransfer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationMasterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationService<Notification> notificationService;
    private final NotificationMapper notificationMapper;
    private MapperModelImpl<BaseDTO,Notification> baseMapper;
    private final PropertyTransfer propertyTransfer;

    @Transactional
    public ResponseEntity<BaseDTO> createNotification(BaseDTO request){
        baseMapper = mapper(request);

        Notification notification = baseMapper.mappToEntity(request);

        notificationService.save(notification);

        BaseDTO response = baseMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Transactional
    public ResponseEntity<BaseDTO> updateNotification(BaseDTO request, Long id){
        baseMapper = mapper(request);

        Notification notification = notificationService.findById(id);

        Notification updated = baseMapper.mappToEntity(request);

        propertyTransfer.copyNonNullProperties(updated,notification);

        notificationService.save(notification);

        BaseDTO response = baseMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<BaseDTO> readNotification(Long id){

        Notification notification = notificationService.findById(id);

        baseMapper = mapper(notification);

        BaseDTO response = baseMapper.mappToDto(notification);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<List<BaseDTO>> getAllNotifications(PaginationAndSortDTO request){
        Page<Notification> notices = notificationService.findAll(request);

        List<BaseDTO> response = notices.stream()
                .map(g -> mapper(g).mappToDto(g))
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

    private MapperModelImpl mapper(Object request){
        MessageMapper messageMapper = new MessageMapper(notificationMapper);
        InvitationMapper invitationMapper = new InvitationMapper(notificationMapper);
        AlertMapper alertMapper = new AlertMapper(notificationMapper);

        if(request instanceof MessageDTO || request instanceof Message){
            return new MapperModelImpl(messageMapper);
        } else if(request instanceof AlertDTO || request instanceof Alert){
            return new MapperModelImpl(alertMapper);
        } else if(request instanceof InvitationDTO || request instanceof Invitation) {
            return new MapperModelImpl(invitationMapper);
        }

        return new MapperModelImpl(new MapperImpl());
    }

}
