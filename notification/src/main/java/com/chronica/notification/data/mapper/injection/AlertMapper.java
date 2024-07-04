package com.chronica.notification.data.mapper.injection;

import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.notification.dto.AlertDTO;
import com.chronica.notification.data.entity.Alert;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper implements BaseMapper<Alert, AlertDTO> {
    private final NotificationMapper notificationMapper;

    public AlertMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public AlertDTO mapToDTO(Alert alert) {
        AlertDTO dto = new AlertDTO();
        notificationMapper.mapToDTO(dto, alert);
        dto.setPriority(alert.getPriority());
        return dto;
    }

    @Override
    public Alert mapToNewEntity(AlertDTO dto) {
        Alert alert = new Alert();
        notificationMapper.mapToNewEntity(alert, dto);
        alert.setPriority(dto.getPriority());
        return alert;
    }

    @Override
    public Alert mapToUpdateEntity(Alert toUpdate, AlertDTO dto) {
        throw new NotImplementedException();
    }
}
