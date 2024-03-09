package com.chronica.notification.data.dto.request;

import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import com.chronica.notification.data.dto.AlertDto;
import com.chronica.notification.data.dto.InvitationDto;
import com.chronica.notification.data.dto.MessageDto;
import com.chronica.notification.data.dto.NotificationDto;

import java.time.LocalDateTime;

public record QueryNoticeRequestDto(String title,
                                    LocalDateTime createdAt,
                                    Long receiverId,
                                    Boolean deprecated,
                                    NotificationType notificationType,
                                    Long messageFromId,
                                    Long invitationFromId,
                                    PriorityType priorityType,
                                    Boolean accepted,
                                    LocalDateTime acceptedAt) {
}
