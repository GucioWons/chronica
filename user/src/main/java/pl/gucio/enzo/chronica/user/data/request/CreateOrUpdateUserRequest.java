package pl.gucio.enzo.chronica.user.data.request;

import pl.gucio.enzo.chronica.user.data.dto.AccountDto;
import pl.gucio.enzo.chronica.user.data.dto.PersonDto;


public record CreateOrUpdateUserRequest(AccountDto accountDto, PersonDto personDto) {
}
