package com.chronica.user.data.dto;

import java.time.LocalDateTime;

public record AuthorizationDTO(String mail, String token, LocalDateTime loggedAt) {
}
