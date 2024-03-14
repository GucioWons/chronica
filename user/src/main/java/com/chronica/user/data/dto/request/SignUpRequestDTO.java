package com.chronica.user.data.dto.request;

import com.chronica.user.data.dto.AccountDTO;
import com.chronica.user.data.dto.PersonDTO;

public record SignUpRequestDTO(AccountDTO account, PersonDTO person) {
}
