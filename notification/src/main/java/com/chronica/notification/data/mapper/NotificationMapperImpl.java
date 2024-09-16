package com.chronica.notification.data.mapper;

import com.chronica.notification.data.entity.Alert;
import com.chronica.notification.data.entity.Invitation;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import org.chronica.library.commons.exception.WrongMapperException;
import com.chronica.notification.data.mapper.injection.AlertMapper;
import com.chronica.notification.data.mapper.injection.InvitationMapper;
import com.chronica.notification.data.mapper.injection.MessageMapper;
import lombok.AllArgsConstructor;
import org.chronica.library.dto.notification.AlertDTO;
import org.chronica.library.dto.notification.InvitationDTO;
import org.chronica.library.dto.notification.MessageDTO;
import org.chronica.library.dto.notification.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationMapperImpl {
    private final InvitationMapper invitationMapper;
    private final MessageMapper messageMapper;
    private final AlertMapper alertMapper;

    public NotificationDTO mapToDTO(Notification notification) {
        if(notification instanceof Alert)
            return alertMapper.mapToDTO((Alert) notification);

        else if(notification instanceof Message)
            return messageMapper.mapToDTO((Message) notification);

        else if(notification instanceof Invitation)
            return invitationMapper.mapToDTO((Invitation) notification);

        throw new WrongMapperException("Its something wrong with entity/mapper couldnt work");
    }

    public Notification mapToNewEntity(NotificationDTO dto) {
        if(dto instanceof AlertDTO)
            return alertMapper.mapToNewEntity((AlertDTO) dto);

        else if(dto instanceof MessageDTO)
            return messageMapper.mapToNewEntity((MessageDTO) dto);

        else if(dto instanceof InvitationDTO)
            return invitationMapper.mapToNewEntity((InvitationDTO) dto);

        throw new WrongMapperException("Its something wrong with entity/mapper couldnt work");
    }
}
