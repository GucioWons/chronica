package com.chronica.user.api.auth.refresh.controller;

import com.chronica.user.api.auth.refresh.logic.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/refresh-token")
public class RefreshTokenController {
    private final RefreshTokenService refreshTokenService;

    @PostMapping
    public ResponseEntity<SignInResultDTO> refreshToken(String token) {
        return refreshTokenService.validateAndRefreshToken(token)
                .map((result) -> ResponseEntity.status(HttpStatus.OK).body(result))
                .orElse(ResponseEntity.status(HttpStatus.FORBIDDEN).build());
    }

    @DeleteMapping
    public ResponseEntity<?> logout(String token) {
        refreshTokenService.deleteRefreshToken(token);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
