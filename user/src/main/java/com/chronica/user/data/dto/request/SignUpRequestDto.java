package com.chronica.user.data.dto.request;

import com.chronica.user.data.dto.AccountDto;
import com.chronica.user.data.dto.PersonDto;

public record SignUpRequestDto(AccountDto account, PersonDto person) {
}
