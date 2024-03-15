package com.chronica.user.data.dto;

import com.chronica.user.data.constant.Role;

import java.time.LocalDateTime;

public record AccountDTO(Long id,
                         String username,
                         String mail,
                         Long phoneNumber,
                         String password,
                         Boolean isActive,
                         Boolean deprecated,
                         Role role,
                         LocalDateTime createdAt
                         ) {
}
