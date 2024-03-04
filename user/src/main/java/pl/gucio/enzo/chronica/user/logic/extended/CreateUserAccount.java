package pl.gucio.enzo.chronica.user.logic.extended;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.request.CreateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.logic.basic.AccountService;
import pl.gucio.enzo.chronica.user.logic.basic.PersonService;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateUserAccount {
    private final AccountService accountService;

    @Transactional
    public ResponseEntity<CreateUserResponse> create(CreateUserRequest createUserRequest){
        final AccountEntity accountEntity = new AccountEntity();
        final PersonEntity personEntity = new PersonEntity();

        personEntity.setName(createUserRequest.getPersonDto().getName());
        personEntity.setLastName(createUserRequest.getPersonDto().getLastName());
        personEntity.setAge(createUserRequest.getPersonDto().getAge());

        accountEntity.setUsername(createUserRequest.getAccountDto().getUsername());
        accountEntity.setMail(createUserRequest.getAccountDto().getMail());
        accountEntity.setPhoneNumber(createUserRequest.getAccountDto().getPhoneNumber());
        accountEntity.setPassword(createUserRequest.getAccountDto().getPassword());
        accountEntity.setPerson(personEntity);

        accountService.create(accountEntity);

        final LocalDateTime createdAt = LocalDateTime.now();

        final CreateUserResponse response = new CreateUserResponse("created At " + createdAt);

        return ResponseEntity.ok(response);
    }
}
