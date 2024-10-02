package com.chronica.user.api.auth.refresh.logic;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.logic.AccountService;
import com.chronica.user.api.account.mapper.AccountMapper;
import com.chronica.user.api.auth.TokenGenerator;
import com.chronica.user.api.auth.refresh.data.RefreshTokenRepository;
import com.chronica.user.api.auth.refresh.entity.RefreshToken;
import com.chronica.user.api.auth.signin.logic.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.chronica.library.security.JWTHandler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final TokenGenerator tokenGenerator;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JWTHandler jwtHandler;
    private final AccountService accountService;
    private final AccessTokenService accessTokenService;
    private final AccountMapper accountMapper;

    public Optional<SignInResultDTO> validateAndRefreshToken(String token) {
        String mail = jwtHandler.extractUsername(token);
        if (jwtHandler.validateToken(mail)) {
            return refreshTokenRepository.findByToken(token)
                    .map(refreshToken -> refreshToken(refreshToken, mail));
        }
        return Optional.empty();
    }

    private SignInResultDTO refreshToken(RefreshToken refreshToken, String mail) {
        Account account = accountService.getAccountByMailAndEnabled(mail);
        SignInResultDTO result = new SignInResultDTO(
                accessTokenService.getAccessToken(account),
                createAndGetRefreshToken(account.getUsername()),
                accountMapper.mapToDTO(account)
        );
        refreshTokenRepository.delete(refreshToken);
        return result;
    }

    public String createAndGetRefreshToken(String userName) {
        Date expirationDate = new Date(System.currentTimeMillis() + (long) 1000 * 60 * 60 * 24 * 7);
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(tokenGenerator.createToken(Collections.emptyMap(), userName, expirationDate));
        refreshToken.setExpirationDate(expirationDate);
        return refreshTokenRepository.save(refreshToken).getToken();
    }
}
