package com.chronica.user.data.dto.request;

import com.chronica.user.data.dto.AccountDto;
import com.chronica.user.data.dto.PersonDto;

public record SignUpRequestDTO(AccountDto account, PersonDto person) {
}
