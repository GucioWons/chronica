package pl.gucio.enzo.chronica.user.data.dto.response;

import java.time.LocalDateTime;

public record SignInResponseDto(String mail, String token, LocalDateTime loggedAt){
}
