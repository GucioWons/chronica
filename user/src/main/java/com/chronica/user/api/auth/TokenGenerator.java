package com.chronica.user.api.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.chronica.library.security.JWTHandler;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class TokenGenerator {
    private final JWTHandler jwtHandler;

    public String createToken(Map<String, Object> claims, String userName, Date expirationDate) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(jwtHandler.getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
