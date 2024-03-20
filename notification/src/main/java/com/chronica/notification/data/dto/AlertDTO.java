package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO extends BaseDTO {
    private PriorityType priorityType;
    private NotificationDTO baseData;
}
