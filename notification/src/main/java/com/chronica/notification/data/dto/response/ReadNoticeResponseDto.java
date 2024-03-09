package com.chronica.notification.data.dto.response;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.NotificationDto;
import lombok.Builder;
import lombok.Data;


public record ReadNoticeResponseDto(
     NotificationType notificationType,
     Long id,
     String title,
     String content,
     Boolean deprecated){
}
