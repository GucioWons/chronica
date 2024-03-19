package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.NotificationType;
import lombok.*;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@Value
public class MessageDTO extends NotificationDTO{
    Long messageFromUserId;
}
