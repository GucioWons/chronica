package com.chronica.user.api.auth.refresh.logic;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.logic.AccountService;
import com.chronica.user.api.account.mapper.AccountMapper;
import com.chronica.user.api.auth.TokenGenerator;
import com.chronica.user.api.auth.refresh.data.RefreshTokenRepository;
import com.chronica.user.api.auth.refresh.entity.RefreshToken;
import com.chronica.user.api.auth.signin.logic.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
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

    public Optional<SignInResultDTO> validateAndRefreshToken(String refreshToken) {
        String mail = jwtHandler.extractUsername(refreshToken);
        if (jwtHandler.validateToken(refreshToken, mail)) {
            return refreshTokenRepository.findByToken(refreshToken)
                    .map(existingRefreshToken -> refreshToken(existingRefreshToken, mail));
        }
        return Optional.empty();
    }

    private SignInResultDTO refreshToken(RefreshToken existingRefreshToken, String mail) {
        Account account = accountService.getAccountByMailAndEnabled(mail);
        AccountDTO accountDTO = accountMapper.mapToDTO(account);
        SignInResultDTO result = new SignInResultDTO(
                accessTokenService.getAccessToken(account.getRoles(), accountDTO),
                createAndGetRefreshToken(account.getMail()),
                accountMapper.mapToDTO(account)
        );
        refreshTokenRepository.delete(existingRefreshToken);
        return result;
    }

    public String createAndGetRefreshToken(String mail) {
        Date expirationDate = new Date(System.currentTimeMillis() + (long) 1000 * 60 * 60 * 24 * 7);
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(tokenGenerator.createToken(Collections.emptyMap(), mail, expirationDate));
        refreshToken.setExpirationDate(expirationDate);
        return refreshTokenRepository.save(refreshToken).getToken();
    }

    public void deleteRefreshToken(String refreshToken) {
        refreshTokenRepository.deleteByToken(refreshToken);
    }
}
