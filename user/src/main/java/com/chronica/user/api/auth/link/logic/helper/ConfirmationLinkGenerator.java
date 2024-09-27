package com.chronica.user.api.auth.link.logic.helper;

import java.security.SecureRandom;

public class ConfirmationLinkGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@ZX123";
    private static final int ID_LENGTH = 26;

    public static String generate() {
        StringBuilder id = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            id.append(CHARACTERS.charAt(randomIndex));
        }
        return id.toString();
    }
}

