package com.chronica.user.data.dto;

public record AccountDto(String username,
                         String mail,
                         Long phoneNumber,
                         String password) {
}
