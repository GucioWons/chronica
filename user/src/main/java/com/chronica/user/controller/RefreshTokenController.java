package com.chronica.user.controller;

import com.chronica.user.logic.RefreshTokenService;
import jakarta.ws.rs.POST;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("refresh-token")
public class RefreshTokenController {
    private final RefreshTokenService refreshTokenService;

    @POST
    public ResponseEntity<SignInResultDTO> refreshToken(String token) {
        return refreshTokenService.refreshToken(token)
                .map((result) -> ResponseEntity.status(HttpStatus.OK).body(result))
                .orElse(ResponseEntity.status(HttpStatus.FORBIDDEN).build());
    }
}
