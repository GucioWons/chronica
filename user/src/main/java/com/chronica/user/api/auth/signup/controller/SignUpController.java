package com.chronica.user.api.auth.signup.controller;

import com.chronica.user.api.auth.signup.logic.SignUpService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/accounts/sign-up", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<AccountDTO> signUp(@RequestBody AccountDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(signUpService.signUp(request));
    }
}
