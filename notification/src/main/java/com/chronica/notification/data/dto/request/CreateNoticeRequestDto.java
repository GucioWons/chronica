package com.chronica.notification.data.dto.request;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.AlertDto;
import com.chronica.notification.data.dto.InvitationDto;
import com.chronica.notification.data.dto.MessageDto;
import com.chronica.notification.data.dto.NotificationDto;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class CreateNoticeRequestDto{
    NotificationType notificationType;
    NotificationDto notification;
    MessageDto message;
    AlertDto alert;
    InvitationDto invitation;
}
