package org.chronica.library.dto.user;

public record SignInResultDTO(String token, String refreshToken, AccountDTO account) {
}
