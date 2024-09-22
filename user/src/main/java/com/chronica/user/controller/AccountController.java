package com.chronica.user.controller;

import com.chronica.user.logic.AccountService;
import com.chronica.user.logic.SignInService;
import com.chronica.user.logic.SignUpService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.dto.user.SignInDTO;
import org.chronica.library.dto.user.SignInResultDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountController {
    private final SignUpService signUpService;
    private final SignInService signInService;
    private final AccountService accountService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<AccountDTO> signUp(@RequestBody AccountDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(signUpService.signUp(request));
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<SignInResultDTO> signIn(@RequestBody SignInDTO request) {
        return signInService.signIn(request)
                .map(response -> ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Authorization", "Bearer " + response.token())
                        .body(response))
                .orElseThrow(() -> new ChronicaException(ErrorMessage.AUTHORIZATION_EXCEPTION));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.getAccountById(id));
    }

    @GetMapping(value = "/chronica-exception")
    public ResponseEntity<AccountDTO> chronicaException() {
        throw new ChronicaException(ErrorMessage.NOT_IMPLEMENTED_EXCEPTION);
    }

    @GetMapping(value = "/exception")
    public ResponseEntity<AccountDTO> exception() {
        throw new RuntimeException();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.deleteAccount(id));
    }

    @GetMapping(value = "/logout")
    public String killSession() {
        return "redirect:/";
    }
}
