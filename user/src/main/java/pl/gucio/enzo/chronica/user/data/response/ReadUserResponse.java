package pl.gucio.enzo.chronica.user.data.response;

import pl.gucio.enzo.chronica.user.data.dto.AccountDto;
import pl.gucio.enzo.chronica.user.data.dto.PersonDto;

public record ReadUserResponse(AccountDto accountDto, PersonDto personDto, String message) {
}
