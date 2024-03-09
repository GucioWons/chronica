package com.chronica.notification.data.dto.response;

import java.time.LocalDateTime;

public record DeprecateNoticeResponseDto(Long id, Boolean deprecate, LocalDateTime deletedAt) {
}
