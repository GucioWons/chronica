package com.chronica.notification.data.dto;

import java.time.LocalDateTime;

public record InvitationDto(Long broadcasterId, Boolean accepted, LocalDateTime acceptedAt) {
}
