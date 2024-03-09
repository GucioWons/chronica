package com.chronica.notification.data.dto.request;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;


@Builder
@Data
@Value
public class UpdateNoticeRequestDto {
    Long id;
    String title;
    String content;
    LocalDateTime createdAt;
    LocalDateTime openAt;
    Long receiverId;
    Boolean deprecated;
    NotificationType notificationType;
    Long messageFromId;
    Long invitationFromId;
    Boolean accepted;
    LocalDateTime acceptedAt;
    PriorityType priorityType;
}
