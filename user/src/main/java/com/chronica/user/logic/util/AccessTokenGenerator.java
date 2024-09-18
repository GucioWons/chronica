package com.chronica.user.logic.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.chronica.library.enumerated.UserRole;
import org.chronica.library.security.JWTHandler;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccessTokenGenerator {
    private final JWTHandler jwtHandler;

    public String generateToken(String userName, List<UserRole> userRoles) {
        Map<String, Object> claims = Map.of("userRoles", userRoles.stream().map(Enum::name).collect(Collectors.toList()));
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(jwtHandler.getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
