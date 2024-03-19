package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.NotificationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class MessageDTO extends NotificationDTO{
    private Long messageFromUserId;

}
