package com.chronica.user.api.auth.refresh.logic.helper;

import com.chronica.user.api.auth.TokenGenerator;
import org.chronica.library.security.JWTHandler;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RefreshTokenGenerator extends TokenGenerator {

    public RefreshTokenGenerator(JWTHandler jwtHandler) {
        super(jwtHandler);
    }

    public String generateToken(String userName) {
        return createToken(Collections.emptyMap(), userName, (long) 1000 * 60 * 60 * 24 * 7);
    }
}
