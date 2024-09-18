package com.chronica.user.logic;

import com.chronica.user.data.entity.Account;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.logic.util.AccessTokenGenerator;
import com.chronica.user.logic.util.RefreshTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInDTO;
import org.chronica.library.dto.user.SignInResultDTO;
import org.chronica.library.enumerated.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final AccountService accountService;
    private final AccessTokenGenerator accessTokenGenerator;
    private final RefreshTokenGenerator refreshTokenGenerator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountMapper accountMapper;

    public Optional<SignInResultDTO> signIn(SignInDTO signInRequest) {
        Account account = accountService.getAccountByMailAndEnabled(signInRequest.mail());
        if (checkPassword(signInRequest.password() + signInRequest.mail(), account.getPassword())) {
            List<UserRole> roles = account.getUserRoles();
            String token = accessTokenGenerator.generateToken(signInRequest.mail(), roles);
            String refreshToken = refreshTokenGenerator.generateToken(signInRequest.mail());
            return Optional.of(new SignInResultDTO(token, refreshToken, accountMapper.mapToDTO(account)));
        }
        return Optional.empty();
    }

    private boolean checkPassword(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
