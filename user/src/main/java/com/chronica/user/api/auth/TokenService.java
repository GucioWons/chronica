package com.chronica.user.api.auth;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.mapper.AccountMapper;
import com.chronica.user.api.auth.refresh.logic.helper.RefreshTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInResultDTO;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final AccessTokenGenerator accessTokenGenerator;
    private final RefreshTokenGenerator refreshTokenGenerator;
    private final AccountMapper accountMapper;

    public SignInResultDTO something(String mail, Account account) {
        String newAccessToken = accessTokenGenerator.generateToken(mail, account.getRoles());
        String refreshToken = refreshTokenGenerator.generateToken(mail);
        return new SignInResultDTO(newAccessToken, refreshToken, accountMapper.mapToDTO(account));
    }
}
