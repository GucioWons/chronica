package com.chronica.user.logic.util;

import com.chronica.user.data.dto.AccountDTO;

public record SignInHelper(String token, AccountDTO account) {
}
