package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.mapper.NotificationMapperStatic;
import com.chronica.notification.data.entity.Message;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.notification.MessageDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper implements BaseMapper<Message, MessageDTO> {

    @Override
    public MessageDTO mapToDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        NotificationMapperStatic.mapToDTO(dto, message);
        dto.setMessageFromUserId(message.getMessageFromUserId());
        return dto;
    }

    @Override
    public Message mapToNewEntity(MessageDTO messageDTO) {
        Message message = new Message();
        NotificationMapperStatic.mapToNewEntity(message, messageDTO);
        message.setMessageFromUserId(messageDTO.getMessageFromUserId());
        return message;
    }

    @Override
    public Message mapToUpdateEntity(Message toUpdate, MessageDTO dto) {
        throw new ChronicaException(ErrorMessage.NOT_IMPLEMENTED_EXCEPTION);
    }
}
