package org.chronica.library.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.notification.enumerated.Priority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO extends NotificationDTO {
    private Priority priority;
}
