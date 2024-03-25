package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.Priority;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO extends NotificationDTO {
    private Priority priority;
}
