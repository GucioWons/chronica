package pl.gucio.enzo.chronica.user.data.request;

import pl.gucio.enzo.chronica.user.data.model.AccountData;
import pl.gucio.enzo.chronica.user.data.model.PersonalInformation;

public record CreateUserRequest(AccountData accountData, PersonalInformation personalInformation) {
}
