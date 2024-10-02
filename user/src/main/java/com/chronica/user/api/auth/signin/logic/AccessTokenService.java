package com.chronica.user.api.auth.signin.logic;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.auth.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccessTokenService {
    private final TokenGenerator tokenGenerator;

    public String getAccessToken(Account account) {
        Map<String, Object> claims = Map.of("userRoles", account.getRoles().stream().map(Enum::name).collect(Collectors.toList()));
        Date expirationDate = new Date(System.currentTimeMillis() + (long) (1000 * 60 * 30));
        return tokenGenerator.createToken(claims, account.getMail(), expirationDate);
    }
}
