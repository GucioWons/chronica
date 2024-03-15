package com.chronica.notification.logic.mapper;

import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.QueryNotificationDTO;
import com.chronica.notification.data.entity.Notification;

import java.time.LocalDateTime;
import java.util.List;


public class NoticeMapper {
    public static NotificationDTO readNoticeResponseMapper(Notification notification){
        return new NotificationDTO(notification.getNotificationType(),notification.getId(), notification.getTitle(), notification.getContent(),
                notification.getCreatedAt(),
                notification.getOpenAt(),
                notification.getReceiverId(),
                notification.getDeprecated(),
                23L,
                33L,
                true,
                LocalDateTime.now(),
                PriorityType.Default);
    }

    public static QueryNotificationDTO queryNoticeResponseMapper(List<Notification> notifications){
        return new QueryNotificationDTO(notifications.stream().map(NoticeMapper::readNoticeResponseMapper).toList());
    }
}
