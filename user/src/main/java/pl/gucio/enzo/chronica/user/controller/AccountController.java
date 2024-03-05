package pl.gucio.enzo.chronica.user.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.request.CreateOrUpdateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.logic.AccountService;

@RestController
@RequestMapping(path = "/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/sign-in")
    public ResponseEntity<CreateUserResponse> createAccount(@RequestBody CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        return accountService.create(createOrUpdateUserRequest);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<AccountEntity> createAccount(@PathVariable Long id) { //TODO mapping variable
        return accountService.findAccountById(id);
    }
}
