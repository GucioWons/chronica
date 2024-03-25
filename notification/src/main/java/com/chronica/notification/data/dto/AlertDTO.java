package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.Priority;
import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.integrant.NotificationDTO;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO extends BaseDTO {
    private Priority priority;
    private NotificationDTO baseData;
}
