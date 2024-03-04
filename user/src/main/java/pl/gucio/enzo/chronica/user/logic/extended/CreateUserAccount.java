package pl.gucio.enzo.chronica.user.logic.extended;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.model.AccountData;
import pl.gucio.enzo.chronica.user.data.model.PersonalInformation;
import pl.gucio.enzo.chronica.user.data.request.CreateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.logic.basic.AccountService;
import pl.gucio.enzo.chronica.user.logic.basic.PersonService;
import pl.gucio.enzo.chronica.user.mapper.AccountMapper;
import pl.gucio.enzo.chronica.user.mapper.PersonMapper;

import java.time.LocalDateTime;

@Service
public class CreateUserAccount {
    private final AccountService accountService;
    private final PersonService personService;

    private AccountMapper accountMapper;
    private PersonMapper personMapper;

    public CreateUserAccount(AccountService accountService, PersonService personService) {
        this.accountService = accountService;
        this.personService = personService;
    }

    @Transactional
    public ResponseEntity<CreateUserResponse> create(CreateUserRequest createUserRequest){
        final AccountData accountData = createUserRequest.accountData();
        final PersonalInformation personalInformation = createUserRequest.personalInformation();
        final AccountEntity accountEntity = accountMapper.mappToEntity(accountData);
        final PersonEntity personEntity = personMapper.mappToEntity(personalInformation);

        accountService.create(accountEntity);
        personService.create(personEntity);

        final LocalDateTime createdAt = LocalDateTime.now();

        final CreateUserResponse response = new CreateUserResponse("created At " + createdAt);

        return ResponseEntity.ok(response);
    }
}
