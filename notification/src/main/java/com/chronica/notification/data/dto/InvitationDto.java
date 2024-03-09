package com.chronica.notification.data.dto;

import java.time.LocalDateTime;

public record InvitationDto(Long invitationFromId, Boolean accepted, LocalDateTime acceptedAt) {
}
