package com.chronica.notification.data.dto.request;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class UpdateNoticeRequestDto {
    protected Long id;
    protected String title;
    protected String content;
    protected LocalDateTime createdAt;
    protected LocalDateTime openAt;
    protected Long receiverId;
    protected Boolean deprecated;
    protected NotificationType notificationType;
    private Long messageFromId;
    private Long invitationFromId;
    private Boolean accepted;
    private LocalDateTime acceptedAt;
    private PriorityType priorityType;
}
