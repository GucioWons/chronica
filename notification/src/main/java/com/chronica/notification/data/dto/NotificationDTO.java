package com.chronica.notification.data.dto;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;

import java.time.LocalDateTime;

public record NotificationDTO(
                              NotificationType notificationType,
                              Long id,
                              String title,
                              String content,
                              LocalDateTime createdAt,
                              LocalDateTime openAt,
                              Long receiverId,
                              Boolean deprecated,
                              Boolean seen,
                              Long messageFromId,
                              Long invitationFromId,
                              Boolean accepted,
                              LocalDateTime acceptedAt,
                              PriorityType priorityType){
}
