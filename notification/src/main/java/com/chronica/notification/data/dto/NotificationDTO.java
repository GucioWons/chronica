package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.constant.SortDirection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
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
