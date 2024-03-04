package pl.gucio.enzo.chronica.user.logic;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.request.CreateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;
import pl.gucio.enzo.chronica.user.logic.basic.AccountService;
import pl.gucio.enzo.chronica.user.logic.extended.CreateUserAccount;

@Service
@RequiredArgsConstructor
public class AccountApi {
    private final CreateUserAccount createUserAccount;

    public ResponseEntity<CreateUserResponse> createUserResponse(CreateUserRequest createUserRequest){
        return createUserAccount.create(createUserRequest);
    }
}
