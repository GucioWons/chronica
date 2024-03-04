package pl.gucio.enzo.chronica.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gucio.enzo.chronica.user.data.request.CreateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.logic.AccountApi;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
    private final AccountApi accountApi;

    public AccountController(AccountApi accountApi){
        this.accountApi = accountApi;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<CreateUserResponse> createAccount(@RequestBody CreateUserRequest createUserRequest){
        return accountApi.createUserResponse(createUserRequest);
    }
}
