package com.chronica.user.api.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.chronica.library.security.JWTHandler;

import java.util.Date;
import java.util.Map;

@RequiredArgsConstructor
public abstract class TokenGenerator {
    private final JWTHandler jwtHandler;

    public String createToken(Map<String, Object> claims, String userName, Long expirationSeconds) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds))
                .signWith(jwtHandler.getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
