package pl.gucio.enzo.chronica.user.domain.request;

import pl.gucio.enzo.chronica.user.domain.model.AccountData;
import pl.gucio.enzo.chronica.user.domain.model.PersonalInformation;

public record CreateUserRequest(AccountData accountData, PersonalInformation personalInformation) {
}
