package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.PriorityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Data
@Value
public class AlertDTO extends NotificationDTO{
    PriorityType priorityType;
}
