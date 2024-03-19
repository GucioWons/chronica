package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.constant.SortDirection;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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
