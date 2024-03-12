package com.chronica.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chronica.user.data.dto.request.SignInRequestDTO;
import com.chronica.user.data.dto.request.SignUpRequestDTO;
import com.chronica.user.data.dto.response.FindAccountResponseDTO;
import com.chronica.user.data.dto.response.SignInResponseDTO;
import com.chronica.user.data.dto.response.SignUpResponseDTO;
import com.chronica.user.logic.AccountService;

@RestController
@RequestMapping(path = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<SignUpResponseDTO> createAccount(@RequestBody SignUpRequestDTO request) {
        return accountService.create(request);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<SignInResponseDTO> loggIn(@RequestBody SignInRequestDTO request) {
        return accountService.signIn(request);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FindAccountResponseDTO> getAccount(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @GetMapping(value = "/logout")
    public String killSession(){
        return "redirect:/";
    }
}
