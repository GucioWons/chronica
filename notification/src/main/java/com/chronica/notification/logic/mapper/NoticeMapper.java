package com.chronica.notification.logic.mapper;

import com.chronica.notification.data.dto.response.QueryNoticeResponseDto;
import com.chronica.notification.data.dto.response.ReadNoticeResponseDto;
import com.chronica.notification.data.entity.Notification;

import java.util.ArrayList;
import java.util.List;


public class NoticeMapper {
    public static ReadNoticeResponseDto readNoticeResponseMapper(Notification notification){
        return new ReadNoticeResponseDto(notification.getNotificationType(),notification.getId(), notification.getTitle(), notification.getContent(),
                notification.getDeprecated());
    }

    public static QueryNoticeResponseDto queryNoticeResponseMapper(List<Notification> notifications){
        return new QueryNoticeResponseDto(notifications.stream().map(NoticeMapper::readNoticeResponseMapper).toList());
    }
}
