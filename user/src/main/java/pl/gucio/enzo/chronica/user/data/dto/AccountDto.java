package pl.gucio.enzo.chronica.user.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountDto {
    private String username;
    private String mail;
    private Long phoneNumber;
    private String password;
}
