package pl.gucio.enzo.chronica.user.data.request;

import lombok.Builder;
import lombok.Getter;
import pl.gucio.enzo.chronica.user.data.dto.AccountDto;
import pl.gucio.enzo.chronica.user.data.dto.PersonDto;


public record CreateUserRequest(AccountDto accountDto, PersonDto personDto) {
}
