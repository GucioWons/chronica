package com.chronica.notification.data.dto.integrant;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.dto.abstraction.BaseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private NotificationType notificationType;
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime viewAt;
    private Long receiverId;
    private Boolean deprecated;
    private Boolean seen;
}
