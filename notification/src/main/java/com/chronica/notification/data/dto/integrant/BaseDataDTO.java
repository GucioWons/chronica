package com.chronica.notification.data.dto.integrant;

import com.chronica.notification.data.constant.NotificationType;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDataDTO {
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
