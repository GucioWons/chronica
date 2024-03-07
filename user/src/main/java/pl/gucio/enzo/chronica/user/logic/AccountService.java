package pl.gucio.enzo.chronica.user.logic;




import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import pl.gucio.enzo.chronica.user.logic.security.Jwt;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountBasicService accountBasicService;
    private final EmailService emailService;
    private final LinkService linkService;
    private final Jwt jwt;
    @Value("${app.account.confirmation.api}")
    private String confirmationAddress;
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public ResponseEntity<CreateUserResponse> create(CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        final AccountEntity accountEntity = new AccountEntity();
        final PersonEntity personEntity = new PersonEntity();
        final String mail = createOrUpdateUserRequest.accountDto().mail();
        final String password = createOrUpdateUserRequest.accountDto().password();

        personEntity.setName(createOrUpdateUserRequest.personDto().name());
        personEntity.setLastName(createOrUpdateUserRequest.personDto().lastName());
        personEntity.setAge(createOrUpdateUserRequest.personDto().age());

        accountEntity.setUsername(createOrUpdateUserRequest.accountDto().username());
        accountEntity.setMail(mail);
        accountEntity.setPhoneNumber(createOrUpdateUserRequest.accountDto().phoneNumber());
        accountEntity.setPassword(bCryptPasswordEncoder.encode(password));
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
        final AccountEntity account = accountBasicService.findAccountByMailAndEnabled(mail);

        if(checkPassword(password,account.getPassword())){
            final String token = jwt.generateToken(mail);
            final HttpHeaders headers = new HttpHeaders();

            headers.add("Authorization", "Bearer " + token);

            final SignInResponse response = new SignInResponse("Zalogowano pomyślnie", token);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .body(response);
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();
    }

    private boolean checkPassword(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

}
