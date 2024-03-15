package com.chronica.user.logic;

import com.chronica.user.data.dto.*;
import com.chronica.user.data.entity.Account;
import com.chronica.user.data.entity.Link;
import com.chronica.user.data.entity.Person;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.data.mapper.PersonMapper;
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
    private final AccountMapper accountMapper;
    private final PersonMapper personMapper;


    @Transactional
    public ResponseEntity<UserDTO> create(UserDTO request) {
        final Account account = accountMapper.mappToEntity(request.account());
        final Person person = personMapper.mappToEntity(request.person());

        account.setPerson(person);

        accountBasicService.update(account);

        final Link linkEntity = new Link();
        linkEntity.setAccount(account);
        linkService.createLinkForAccount(linkEntity);

        final String link = confirmationAddress + linkEntity.getGeneratedCode();
        final String htmlBody = "<h1>Witaj!</h1><p>Kliknij <a href='" + link + "'>tutaj</a> aby aktywować swoje konto.</p>";

        emailService.sendEmail(account.getMail(), "Welcome: Account Confirmation", htmlBody);

        final UserDTO response = new UserDTO(accountMapper.mappToDTO(account),personMapper.mappToDTO(person));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    public ResponseEntity<UserDTO> findAccountById(Long id) {
        final Account account = accountBasicService.findAccountById(id);
        final Person person = account.getPerson();

        final AccountDTO accountDTO = accountMapper.mappToDTO(account);
        final PersonDTO personDTO = personMapper.mappToDTO(person);

        final UserDTO response = new UserDTO(accountDTO, personDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<String> deleteAccount(Long id) {
        final Account account = accountBasicService.findAccountById(id);

        account.setDeprecated(true);

        accountBasicService.update(account);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Usunieto konto o id " + id);
    }

    public ResponseEntity<AuthorizationDTO> signIn(SignInDTO request) {
        final String mail = request.mail();
        final String password = request.password();
        final Account account = accountBasicService.findAccountByMailAndEnabled(mail);

        if (checkPassword(password, account.getPassword())) {
            final String token = JWTHandler.generateToken(mail);
            final HttpHeaders headers = new HttpHeaders();

            headers.add("Authorization", "Bearer " + token);

            final AuthorizationDTO response = new AuthorizationDTO(mail, token, LocalDateTime.now());

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
