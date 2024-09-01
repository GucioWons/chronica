package org.chronica.library.dto.user;

import java.time.LocalDateTime;

public record LinkConfirmationDTO(String mail, Boolean isActivated, LocalDateTime confirmedAt) {
}
