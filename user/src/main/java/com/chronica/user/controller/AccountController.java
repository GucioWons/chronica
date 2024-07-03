package com.chronica.user.controller;

import org.chronica.library.user.dto.AccountDTO;
import org.chronica.library.user.dto.SignInDTO;
import com.chronica.user.logic.AccountService;
import com.chronica.user.logic.SignInService;
import com.chronica.user.logic.SignUpService;
import com.chronica.user.logic.util.SignInHelper;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<SignInHelper> signIn(@RequestBody SignInDTO request) {
        return signInService.signIn(request)
                .map(response -> ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Authorization", "Bearer " + response.token())
                        .body(response))
                .orElse(ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.getAccountById(id));
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
