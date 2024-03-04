package pl.gucio.enzo.chronica.user.logic;




import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.repository.AccountRepository;
import pl.gucio.enzo.chronica.user.data.request.CreateOrUpdateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public ResponseEntity<CreateUserResponse> create(CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        final AccountEntity accountEntity = new AccountEntity();
        final PersonEntity personEntity = new PersonEntity();

        personEntity.setName(createOrUpdateUserRequest.personDto().getName());
        personEntity.setLastName(createOrUpdateUserRequest.personDto().getLastName());
        personEntity.setAge(createOrUpdateUserRequest.personDto().getAge());

        accountEntity.setUsername(createOrUpdateUserRequest.accountDto().getUsername());
        accountEntity.setMail(createOrUpdateUserRequest.accountDto().getMail());
        accountEntity.setPhoneNumber(createOrUpdateUserRequest.accountDto().getPhoneNumber());
        accountEntity.setPassword(createOrUpdateUserRequest.accountDto().getPassword());
        accountEntity.setPerson(personEntity);


        accountRepository.save(accountEntity);

        final LocalDateTime createdAt = LocalDateTime.now();

        final CreateUserResponse response = new CreateUserResponse("created At " + createdAt);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
