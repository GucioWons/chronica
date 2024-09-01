package org.chronica.library.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.enumerated.AlertPriority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO extends NotificationDTO {
    private AlertPriority alertPriority;
}
