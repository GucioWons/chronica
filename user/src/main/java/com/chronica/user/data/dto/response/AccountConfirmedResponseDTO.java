package com.chronica.user.data.dto.response;

import java.time.LocalDateTime;

public record AccountConfirmedResponseDTO(String mail, Boolean isActivated, LocalDateTime confirmedAt) {
}
