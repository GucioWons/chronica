package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.Priority;
import com.chronica.notification.data.dto.abstraction.NotificationDTO;
import com.chronica.notification.data.dto.integrant.BaseDataDTO;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO extends NotificationDTO {
    private Priority priority;
    private BaseDataDTO baseData;
}
