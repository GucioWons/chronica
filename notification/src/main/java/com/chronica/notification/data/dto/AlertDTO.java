package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class AlertDTO extends NotificationDTO{
    private PriorityType priorityType;
}
