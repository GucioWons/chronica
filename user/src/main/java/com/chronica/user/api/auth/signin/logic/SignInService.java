package com.chronica.user.api.auth.signin.logic;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.logic.AccountService;
import com.chronica.user.api.account.mapper.AccountMapper;
import com.chronica.user.api.auth.refresh.logic.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.dto.user.SignInDTO;
import org.chronica.library.dto.user.SignInResultDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final AccountService accountService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccessTokenService accessTokenService;
    private final RefreshTokenService refreshTokenService;
    private final AccountMapper accountMapper;

    public Optional<SignInResultDTO> signIn(SignInDTO signInRequest) {
        Account account = accountService.getAccountByMailAndEnabled(signInRequest.mail());
        if (checkPassword(signInRequest.password() + signInRequest.mail(), account.getPassword())) {
            AccountDTO accountDTO = accountMapper.mapToDTO(account);
            return Optional.of(new SignInResultDTO(
                    accessTokenService.getAccessToken(account.getRoles(), accountDTO),
                    refreshTokenService.createAndGetRefreshToken(account.getUsername()),
                    accountDTO)
            );
        }
        return Optional.empty();
    }

    private boolean checkPassword(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
