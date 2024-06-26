package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.AlertDTO;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.mapper.abstraction.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper implements Mapper<AlertDTO,Alert> {
    private final NotificationMapper notificationMapper;

    public AlertMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public AlertDTO mappToDto(Alert alert) {
        AlertDTO dto = new AlertDTO();

        notificationMapper.mappToDto(dto, alert);

        dto.setPriority(alert.getPriority());
        return dto;
    }

    @Override
    public Alert mappToEntity(AlertDTO alertDTO) {
        Alert alert = new Alert();

        notificationMapper.mappToEntity(alert, alertDTO);

        alert.setPriority(alertDTO.getPriority());

        return alert;
    }
}
