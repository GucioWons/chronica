package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.MessageDTO;
import com.chronica.notification.data.dto.integrant.BaseDataDTO;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.mapper.abstraction.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper implements Mapper<MessageDTO,Message> {

    private final NotificationMapper notificationMapper;

    public MessageMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    public MessageDTO mappToDto(Message message) {
        MessageDTO dto = new MessageDTO();
      BaseDataDTO baseData = notificationMapper.mappToDto(message);
      dto.setBaseData(baseData);
      dto.setMessageFromUserId(message.getMessageFromUserId());
      return dto;
    }

    public Message mappToEntity(MessageDTO messageDTO) {
        Message message = new Message();

        notificationMapper.mappToEntity(message,messageDTO.getBaseData());

        message.setMessageFromUserId(messageDTO.getMessageFromUserId());

        return message;
    }
}
