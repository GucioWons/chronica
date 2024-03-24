package com.chronica.notification.data.mapper;

import com.chronica.notification.data.dto.AlertDTO;
import com.chronica.notification.data.dto.InvitationDTO;
import com.chronica.notification.data.dto.MessageDTO;
import com.chronica.notification.data.dto.abstraction.BaseDTO;
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

    public BaseDTO mappToDto(Notification notification) {
        if(notification instanceof Alert)
            return alertMapper.mappToDto((Alert) notification);

        else if(notification instanceof Message)
            return messageMapper.mappToDto((Message) notification);

        else if(notification instanceof Invitation)
            return invitationMapper.mappToDto((Invitation) notification);

        throw new WrongMapperException("Its something wrong with entity/mapper couldnt work");
    }


    public Notification mappToEntity(BaseDTO dto) {
        if(dto instanceof AlertDTO)
            return alertMapper.mappToEntity((AlertDTO) dto);

        else if(dto instanceof MessageDTO)
            return messageMapper.mappToEntity((MessageDTO) dto);

        else if(dto instanceof InvitationDTO)
            return invitationMapper.mappToEntity((InvitationDTO) dto);

        throw new WrongMapperException("Its something wrong with entity/mapper couldnt work");
    }
}
