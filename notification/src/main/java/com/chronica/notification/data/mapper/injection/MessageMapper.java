package com.chronica.notification.data.mapper.injection;

import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.notification.dto.MessageDTO;
import com.chronica.notification.data.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper implements BaseMapper<Message, MessageDTO> {
    private final NotificationMapper notificationMapper;

    public MessageMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public MessageDTO mapToDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        notificationMapper.mapToDTO(dto, message);
        dto.setMessageFromUserId(message.getMessageFromUserId());
        return dto;
    }

    @Override
    public Message mapToNewEntity(MessageDTO messageDTO) {
        Message message = new Message();
        notificationMapper.mapToNewEntity(message,messageDTO);
        message.setMessageFromUserId(messageDTO.getMessageFromUserId());
        return message;
    }

    @Override
    public Message mapToUpdateEntity(Message toUpdate, MessageDTO dto) {
        throw new NotImplementedException();
    }
}
