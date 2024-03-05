package pl.gucio.enzo.chronica.user.logic.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongCredentialsException extends IllegalArgumentException{
    public WrongCredentialsException(String message){
        super(message);
    }
}
