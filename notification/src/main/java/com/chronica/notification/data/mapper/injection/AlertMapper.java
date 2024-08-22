package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.mapper.NotificationMapperStatic;
import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.notification.dto.AlertDTO;
import com.chronica.notification.data.entity.Alert;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper implements BaseMapper<Alert, AlertDTO> {

    @Override
    public AlertDTO mapToDTO(Alert alert) {
        AlertDTO dto = new AlertDTO();
        NotificationMapperStatic.mapToDTO(dto, alert);
        dto.setPriority(alert.getPriority());
        return dto;
    }

    @Override
    public Alert mapToNewEntity(AlertDTO dto) {
        Alert alert = new Alert();
        NotificationMapperStatic.mapToNewEntity(alert, dto);
        alert.setPriority(dto.getPriority());
        return alert;
    }

    @Override
    public Alert mapToUpdateEntity(Alert toUpdate, AlertDTO dto) {
        throw new NotImplementedException();
    }
}
