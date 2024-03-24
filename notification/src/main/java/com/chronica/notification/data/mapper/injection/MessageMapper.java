package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.MessageDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import com.chronica.notification.data.entity.Message;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.abstraction.Mapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MessageMapper implements Mapper<MessageDTO,Message> {

    private final NotificationMapper notificationMapper;

    public MessageMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    public MessageDTO mappToDto(Message message) {
        MessageDTO dto = new MessageDTO();
      NotificationDTO baseData = notificationMapper.mappToDto(message);
      dto.setBaseData(baseData);
      dto.setMessageFromUserId(message.getMessageFromUserId());
      return dto;
    }

    public Message mappToEntity(MessageDTO messageDTO) {
        Message message = new Message();
        message.setMessageFromUserId(messageDTO.getMessageFromUserId());
        Notification notification = notificationMapper.mappToEntity(messageDTO.getBaseData());
        message.setNotification(notification);
        return message;
    }
}
