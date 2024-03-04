package pl.gucio.enzo.chronica.user.data.request;

import pl.gucio.enzo.chronica.user.data.dto.AccountDto;
import pl.gucio.enzo.chronica.user.data.dto.PersonDto;

public class CreateUserRequest {
  private AccountDto accountDto;
  private PersonDto personDto;

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
}
