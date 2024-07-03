package com.chronica.user.logic;

import org.chronica.library.user.dto.SignInDTO;
import com.chronica.user.data.entity.Account;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.logic.security.JWTHandler;
import com.chronica.user.logic.util.SignInHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final AccountService accountService;
    private final JWTHandler jwtHandler;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountMapper accountMapper;

    public Optional<SignInHelper> signIn(SignInDTO signInRequest) {
        Account account = accountService.getAccountByMailAndEnabled(signInRequest.mail());
        if (checkPassword(signInRequest.password() + signInRequest.mail(), account.getPassword())) {
            String token = jwtHandler.generateToken(signInRequest.mail());
            return Optional.of(new SignInHelper(token, accountMapper.mapToDTO(account)));
        }
        return Optional.empty();
    }

    private boolean checkPassword(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
