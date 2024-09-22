package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.mapper.NotificationMapperStatic;
import com.chronica.notification.data.entity.Alert;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.notification.AlertDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper implements BaseMapper<Alert, AlertDTO> {

    @Override
    public AlertDTO mapToDTO(Alert alert) {
        AlertDTO dto = new AlertDTO();
        NotificationMapperStatic.mapToDTO(dto, alert);
        dto.setAlertPriority(alert.getAlertPriority());
        return dto;
    }

    @Override
    public Alert mapToNewEntity(AlertDTO dto) {
        Alert alert = new Alert();
        NotificationMapperStatic.mapToNewEntity(alert, dto);
        alert.setAlertPriority(dto.getAlertPriority());
        return alert;
    }

    @Override
    public Alert mapToUpdateEntity(Alert toUpdate, AlertDTO dto) {
        throw new ChronicaException(ErrorMessage.NOT_IMPLEMENTED_EXCEPTION);
    }
}
