package com.chronica.user.api.auth.signin.controller;

import com.chronica.user.api.auth.signin.logic.SignInService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.SignInDTO;
import org.chronica.library.dto.user.SignInResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sign-in", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class SignInController {
    private final SignInService signInService;

    @PostMapping
    public ResponseEntity<SignInResultDTO> signIn(@RequestBody SignInDTO request) {
        return signInService.signIn(request)
                .map(response -> ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Authorization", "Bearer " + response.token())
                        .body(response))
                .orElse(ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .build());
    }
}
