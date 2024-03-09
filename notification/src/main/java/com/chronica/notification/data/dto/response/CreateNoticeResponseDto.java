package com.chronica.notification.data.dto.response;

import com.chronica.notification.data.constant.NotificationType;

import java.time.LocalDateTime;

public record CreateNoticeResponseDto(NotificationType notificationType, LocalDateTime createdAt) {
}
