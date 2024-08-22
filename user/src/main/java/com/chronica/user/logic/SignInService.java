package com.chronica.user.logic;

import org.chronica.library.user.dto.SignInDTO;
import com.chronica.user.data.entity.Account;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.logic.security.JWTHandler;
import org.chronica.library.user.dto.SignInResultDTO;
import lombok.RequiredArgsConstructor;
import org.chronica.library.user.enumerated.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final AccountService accountService;
    private final JWTHandler jwtHandler;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountMapper accountMapper;

    public Optional<SignInResultDTO> signIn(SignInDTO signInRequest) {
        Account account = accountService.getAccountByMailAndEnabled(signInRequest.mail());
        if (checkPassword(signInRequest.password() + signInRequest.mail(), account.getPassword())) {
            List<Role> roles = account.getRoles();
            String token = jwtHandler.generateToken(signInRequest.mail(), roles);
            return Optional.of(new SignInResultDTO(token, accountMapper.mapToDTO(account)));
        }
        return Optional.empty();
    }

    private boolean checkPassword(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
