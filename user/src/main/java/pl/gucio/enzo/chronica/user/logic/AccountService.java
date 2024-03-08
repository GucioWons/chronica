package pl.gucio.enzo.chronica.user.logic;




import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.Account;
import pl.gucio.enzo.chronica.user.data.entity.Link;
import pl.gucio.enzo.chronica.user.data.entity.Person;
import pl.gucio.enzo.chronica.user.data.request.CreateOrUpdateUserRequest;
import pl.gucio.enzo.chronica.user.data.request.SignInRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
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
        final Account account = new Account();
        final Person person = new Person();
        final String mail = createOrUpdateUserRequest.accountDto().mail();
        final String password = createOrUpdateUserRequest.accountDto().password();

        person.setName(createOrUpdateUserRequest.personDto().name());
        person.setLastName(createOrUpdateUserRequest.personDto().lastName());
        person.setAge(createOrUpdateUserRequest.personDto().age());

        account.setUsername(createOrUpdateUserRequest.accountDto().username());
        account.setMail(mail);
        account.setPhoneNumber(createOrUpdateUserRequest.accountDto().phoneNumber());
        account.setPassword(bCryptPasswordEncoder.encode(password));
        account.setPerson(person);

        accountBasicService.update(account);

        final Link linkEntity = new Link();
        linkEntity.setAccount(account);
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

    public ResponseEntity<Account> findAccountById(Long id){
        final Account response = accountBasicService.findAccountById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build(); //TODO need mapper to JSON
    }

    public ResponseEntity<SignInResponse> signIn(SignInRequest request){
        final String mail = request.mail();
        final String password = request.password();
        final Account account = accountBasicService.findAccountByMailAndEnabled(mail);

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
