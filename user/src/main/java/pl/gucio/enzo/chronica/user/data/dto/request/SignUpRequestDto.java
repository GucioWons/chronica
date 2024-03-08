package pl.gucio.enzo.chronica.user.data.dto.request;

import pl.gucio.enzo.chronica.user.data.dto.AccountDto;
import pl.gucio.enzo.chronica.user.data.dto.PersonDto;

public record SignUpRequestDto(AccountDto account, PersonDto person) {
}
