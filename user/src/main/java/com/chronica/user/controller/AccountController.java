package com.chronica.user.controller;

import com.chronica.user.data.dto.SignInDTO;
import com.chronica.user.data.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chronica.user.data.dto.AuthorizationDTO;
import com.chronica.user.logic.AccountService;

@RestController
@RequestMapping(path = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<UserDTO> createAccount(@RequestBody UserDTO request) {
        return accountService.create(request);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<AuthorizationDTO> loggIn(@RequestBody SignInDTO request) {
        return accountService.signIn(request);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getAccount(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

    @GetMapping(value = "/logout")
    public String killSession() {
        return "redirect:/";
    }
}
