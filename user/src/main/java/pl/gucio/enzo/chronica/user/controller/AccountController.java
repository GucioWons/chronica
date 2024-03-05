package pl.gucio.enzo.chronica.user.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.request.CreateOrUpdateUserRequest;
import pl.gucio.enzo.chronica.user.data.request.SignInRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.data.response.SignInResponse;
import pl.gucio.enzo.chronica.user.logic.AccountService;

@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<CreateUserResponse> createAccount(@RequestBody CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        return accountService.create(createOrUpdateUserRequest);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<SignInResponse> loggIn(@RequestBody SignInRequest request) {
        return accountService.signIn(request);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<AccountEntity> createAccount(@PathVariable Long id) { //TODO mapping variable
        return accountService.findAccountById(id);
    }

    @GetMapping(value = "/logout")
    public String killSession(){
        return "redirect:/";
    }
}
