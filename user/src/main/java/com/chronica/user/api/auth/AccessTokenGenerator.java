package com.chronica.user.api.auth;

import com.chronica.user.api.auth.TokenGenerator;
import org.chronica.library.enumerated.UserRole;
import org.chronica.library.security.JWTHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AccessTokenGenerator extends TokenGenerator {
    public AccessTokenGenerator(JWTHandler jwtHandler) {
        super(jwtHandler);
    }

    public String generateToken(String userName, List<UserRole> userRoles) {
        Map<String, Object> claims = Map.of("userRoles", userRoles.stream().map(Enum::name).collect(Collectors.toList()));
        return createToken(claims, userName, (long) (1000 * 60 * 30));
    }
}
