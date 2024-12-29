package com.chronica.user.api.auth.refresh.controller;

import com.chronica.user.api.auth.refresh.logic.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/refresh-token")
public class RefreshTokenController {
    private final RefreshTokenService refreshTokenService;

    @PostMapping
    public ResponseEntity<SignInResultDTO> refreshToken(String token) {
        return refreshTokenService.validateAndRefreshToken(token)
                .map((result) -> ResponseEntity.status(HttpStatus.OK).body(result))
                .orElseThrow(() -> new ChronicaException(ErrorMessage.EXPIRED_REFRESH_TOKEN_EXCEPTION));
    }

    @DeleteMapping
    public ResponseEntity<?> logout(String token) {
        refreshTokenService.deleteRefreshToken(token);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
