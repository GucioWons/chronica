package com.chronica.user.logic;

import com.chronica.user.data.entity.Account;
import com.chronica.user.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
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
