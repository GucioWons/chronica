package org.chronica.library.user.dto;

import java.time.LocalDateTime;

public record LinkConfirmationDTO(String mail, Boolean isActivated, LocalDateTime confirmedAt) {
}
