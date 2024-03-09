package com.chronica.notification.data.dto.response;

import java.time.LocalDateTime;

public record UpdateNoticeResponseDto(Long id, LocalDateTime updatedAt) {
}
