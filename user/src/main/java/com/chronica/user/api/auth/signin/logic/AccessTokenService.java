package com.chronica.user.api.auth.signin.logic;

import com.chronica.user.api.auth.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.enumerated.UserRole;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccessTokenService {
    private final TokenGenerator tokenGenerator;

    public String getAccessToken(List<UserRole> roles, AccountDTO account) {
        Map<String, Object> claims = Map.of(
                "userRoles", roles.stream().map(Enum::name).collect(Collectors.toList()),
                "account", account);
        Date expirationDate = new Date(System.currentTimeMillis() + (long) (1000 * 60 * 5));
        return tokenGenerator.createToken(claims, account.getMail(), expirationDate);
    }
}
