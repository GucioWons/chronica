package com.chronica.user.logic;




import com.chronica.user.data.entity.Account;
import com.chronica.user.data.entity.Link;
import com.chronica.user.data.entity.Person;
import com.chronica.user.logic.basic.AccountBasicService;
import com.chronica.user.logic.security.JWTHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.chronica.user.data.dto.request.SignInRequestDTO;
import com.chronica.user.data.dto.request.SignUpRequestDTO;
import com.chronica.user.data.dto.response.FindAccountResponseDTO;
import com.chronica.user.data.dto.response.SignInResponseDTO;
import com.chronica.user.data.dto.response.SignUpResponseDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountBasicService accountBasicService;
    private final EmailService emailService;
    private final LinkService linkService;
    private final JWTHandler JWTHandler;
    @Value("${app.account.confirmation.api}")
    private String confirmationAddress;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public ResponseEntity<SignUpResponseDTO> create(SignUpRequestDTO request) {
        final Account account = new Account();
        final Person person = new Person();
        final String mail = request.account().mail();
        final String password = request.account().password();

        person.setName(request.person().name());
        person.setLastName(request.person().lastName());
        person.setAge(request.person().age());

        account.setUsername(request.account().username());
        account.setMail(mail);
        account.setPhoneNumber(request.account().phoneNumber());
        account.setPassword(bCryptPasswordEncoder.encode(password));
        account.setPerson(person);

        accountBasicService.update(account);

        final Link linkEntity = new Link();
        linkEntity.setAccount(account);
        linkService.createLinkForAccount(linkEntity);

        final String link = confirmationAddress + linkEntity.getGeneratedCode();
        final String htmlBody = "<h1>Witaj!</h1><p>Kliknij <a href='" + link + "'>tutaj</a> aby aktywować swoje konto.</p>";

        emailService.sendEmail(mail, "Welcome: Account Confirmation", htmlBody);

        final SignUpResponseDTO response = new SignUpResponseDTO(mail, LocalDateTime.now(), account.getIsActive());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    public ResponseEntity<FindAccountResponseDTO> findAccountById(Long id){
        final Account account = accountBasicService.findAccountById(id);
        final FindAccountResponseDTO response = new FindAccountResponseDTO(account.getUsername(), account.getMail(), account.getPhoneNumber());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<SignInResponseDTO> signIn(SignInRequestDTO request){
        final String mail = request.mail();
        final String password = request.password();
        final Account account = accountBasicService.findAccountByMailAndEnabled(mail);

        if(checkPassword(password,account.getPassword())){
            final String token = JWTHandler.generateToken(mail);
            final HttpHeaders headers = new HttpHeaders();

            headers.add("Authorization", "Bearer " + token);

            final SignInResponseDTO response = new SignInResponseDTO(mail,token, LocalDateTime.now());

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
