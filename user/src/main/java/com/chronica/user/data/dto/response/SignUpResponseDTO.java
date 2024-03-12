package com.chronica.user.data.dto.response;

import java.time.LocalDateTime;

public record SignUpResponseDTO(String mail, LocalDateTime createdAt, Boolean isActivated) {
}
