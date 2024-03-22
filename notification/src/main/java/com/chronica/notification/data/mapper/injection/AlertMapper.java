package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.AlertDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.abstraction.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AlertMapper implements Mapper<AlertDTO,Alert> {
    private final NotificationMapper notificationMapper;

    public AlertMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }


    @Override
    public AlertDTO mappToDto(Alert alert) {
        NotificationDTO notificationDTO = notificationMapper.mappToDto(alert);
        AlertDTO dto = new AlertDTO();
        dto.setBaseData(notificationDTO);
        dto.setPriorityType(alert.getPriorityType());
        return dto;
    }

    @Override
    public Alert mappToEntity(AlertDTO alertDTO) {
        Notification notification = notificationMapper.mappToEntity(alertDTO.getBaseData());
        Alert alert = new Alert();
        alert.setNotification(notification);
        alert.setPriorityType(alertDTO.getPriorityType());
        return alert;
    }
}
