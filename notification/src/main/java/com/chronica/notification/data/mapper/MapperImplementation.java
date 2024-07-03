package com.chronica.notification.data.mapper;

import org.chronica.library.notification.dto.AlertDTO;
import org.chronica.library.notification.dto.InvitationDTO;
import org.chronica.library.notification.dto.MessageDTO;
import org.chronica.library.notification.dto.NotificationDTO;
import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.exception.WrongMapperException;
import com.chronica.notification.data.mapper.injection.AlertMapper;
import com.chronica.notification.data.mapper.injection.InvitationMapper;
import com.chronica.notification.data.mapper.injection.MessageMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapperImplementation {
    private final InvitationMapper invitationMapper;
    private final MessageMapper messageMapper;
    private final AlertMapper alertMapper;

    public NotificationDTO mappToDto(Notification notification) {
        if(notification instanceof Alert)
            return alertMapper.mappToDto((Alert) notification);

        else if(notification instanceof Message)
            return messageMapper.mappToDto((Message) notification);

        else if(notification instanceof Invitation)
            return invitationMapper.mappToDto((Invitation) notification);

        throw new WrongMapperException("Its something wrong with entity/mapper couldnt work");
    }


    public Notification mappToEntity(NotificationDTO dto) {
        if(dto instanceof AlertDTO)
            return alertMapper.mappToEntity((AlertDTO) dto);

        else if(dto instanceof MessageDTO)
            return messageMapper.mappToEntity((MessageDTO) dto);

        else if(dto instanceof InvitationDTO)
            return invitationMapper.mappToEntity((InvitationDTO) dto);

        throw new WrongMapperException("Its something wrong with entity/mapper couldnt work");
    }
}
