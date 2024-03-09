package com.chronica.notification.data.dto.request;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.AlertDto;
import com.chronica.notification.data.dto.InvitationDto;
import com.chronica.notification.data.dto.MessageDto;
import com.chronica.notification.data.dto.NotificationDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateNoticeRequestDto{
    private NotificationType notificationType;
    private NotificationDto notification;
    private MessageDto message;
    private AlertDto alert;
    private InvitationDto invitation;
}
