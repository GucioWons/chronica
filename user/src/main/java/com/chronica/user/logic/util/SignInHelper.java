package com.chronica.user.logic.util;

import org.chronica.library.user.dto.AccountDTO;

public record SignInHelper(String token, AccountDTO account) {
}
