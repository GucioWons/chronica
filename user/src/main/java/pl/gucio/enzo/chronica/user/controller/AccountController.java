package pl.gucio.enzo.chronica.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gucio.enzo.chronica.user.data.dto.request.SignInRequestDto;
import pl.gucio.enzo.chronica.user.data.dto.request.SignUpRequestDto;
import pl.gucio.enzo.chronica.user.data.dto.response.FindAccountResponseDto;
import pl.gucio.enzo.chronica.user.data.dto.response.SignInResponseDto;
import pl.gucio.enzo.chronica.user.data.dto.response.SignUpResponseDto;
import pl.gucio.enzo.chronica.user.logic.AccountService;

@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<SignUpResponseDto> createAccount(@RequestBody SignUpRequestDto request) {
        return accountService.create(request);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<SignInResponseDto> loggIn(@RequestBody SignInRequestDto request) {
        return accountService.signIn(request);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<FindAccountResponseDto> createAccount(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @GetMapping(value = "/logout")
    public String killSession(){
        return "redirect:/";
    }
}
