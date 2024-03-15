package com.chronica.user.data.dto;

import java.time.LocalDateTime;

public record LinkConfirmationDTO(String mail, Boolean isActivated, LocalDateTime confirmedAt) {
}
