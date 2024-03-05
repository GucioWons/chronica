package pl.gucio.enzo.chronica.user.logic;




import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.entity.LinkEntity;
import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.repository.AccountRepository;
import pl.gucio.enzo.chronica.user.data.request.CreateOrUpdateUserRequest;
import pl.gucio.enzo.chronica.user.data.request.SignInRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.data.response.ReadUserResponse;
import pl.gucio.enzo.chronica.user.data.response.SignInResponse;
import pl.gucio.enzo.chronica.user.logic.basic.AccountBasicService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountBasicService accountBasicService;
    private final EmailService emailService;
    private final LinkService linkService;
    @Value("${app.account.confirmation.api}")
    private String confirmationAddress;

    @Transactional
    public ResponseEntity<CreateUserResponse> create(CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        final AccountEntity accountEntity = new AccountEntity();
        final PersonEntity personEntity = new PersonEntity();
        final String mail = createOrUpdateUserRequest.accountDto().getMail();

        personEntity.setName(createOrUpdateUserRequest.personDto().getName());
        personEntity.setLastName(createOrUpdateUserRequest.personDto().getLastName());
        personEntity.setAge(createOrUpdateUserRequest.personDto().getAge());

        accountEntity.setUsername(createOrUpdateUserRequest.accountDto().getUsername());
        accountEntity.setMail(mail);
        accountEntity.setPhoneNumber(createOrUpdateUserRequest.accountDto().getPhoneNumber());
        accountEntity.setPassword(createOrUpdateUserRequest.accountDto().getPassword());
        accountEntity.setPerson(personEntity);

        accountBasicService.update(accountEntity);

        final LinkEntity linkEntity = new LinkEntity();
        linkEntity.setAccount(accountEntity);
        linkService.createLinkForAccount(linkEntity);

        final String link = confirmationAddress + linkEntity.getGeneratedCode();
        final String htmlBody = "<h1>Witaj!</h1><p>Kliknij <a href='" + link + "'>tutaj</a> aby aktywować swoje konto.</p>";

        emailService.sendEmail(mail, "Welcome: Account Confirmation", htmlBody);

        final LocalDateTime createdAt = LocalDateTime.now();

        final CreateUserResponse response = new CreateUserResponse("Konto utworzono: " + createdAt + " Wyslano link weryfikacyjny na podany adres mail: " + mail);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    public ResponseEntity<AccountEntity> findAccountById(Long id){
        final AccountEntity response = accountBasicService.findAccountById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build(); //TODO need mapper to JSON
    }

    public ResponseEntity<SignInResponse> signIn(SignInRequest request){
        final String mail = request.mail();
        final String password = request.password();
        final AccountEntity account = accountBasicService.findAccountByMailPasswordAndEnabled(mail,password);

        SignInResponse response = new SignInResponse("Zalogowano pomyślnie");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }


}
