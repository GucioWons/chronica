package pl.gucio.enzo.chronica.user.logic;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.request.CreateUserRequest;
import pl.gucio.enzo.chronica.user.data.response.CreateUserResponse;

import pl.gucio.enzo.chronica.user.logic.extended.CreateUserAccount;

@Service
public class AccountApi {
    private final CreateUserAccount createUserAccount;

    public AccountApi(CreateUserAccount createUserAccount){
        this.createUserAccount = createUserAccount;
    }

    public ResponseEntity<CreateUserResponse> createUserResponse(CreateUserRequest createUserRequest){
        return createUserAccount.create(createUserRequest);
    }
}
