package com.chronica.user.data.dto.response;

import java.time.LocalDateTime;

public record SignUpResponseDto(String mail, LocalDateTime createdAt, Boolean isActivated) {
}
