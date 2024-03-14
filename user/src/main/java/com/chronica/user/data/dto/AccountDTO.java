package com.chronica.user.data.dto;

public record AccountDTO(String username,
                         String mail,
                         Long phoneNumber,
                         String password) {
}
