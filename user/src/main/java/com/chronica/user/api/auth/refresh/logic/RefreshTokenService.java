package com.chronica.user.api.auth.refresh.logic;

import com.chronica.user.api.auth.TokenService;
import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.logic.AccountService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.chronica.library.security.JWTHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final JWTHandler jwtHandler;
    private final AccountService accountService;
    private final TokenService tokenService;

    public Optional<SignInResultDTO> refreshToken(String token) {
        String mail = jwtHandler.extractUsername(token);
        if (jwtHandler.validateToken(mail)) {
            Account account = accountService.getAccountByMailAndEnabled(mail);
            return Optional.of(tokenService.something(mail, account));
        }
        return Optional.empty();
    }
}
