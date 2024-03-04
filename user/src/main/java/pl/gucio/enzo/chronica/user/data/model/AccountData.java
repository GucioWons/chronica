package pl.gucio.enzo.chronica.user.data.model;


import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
@With
public class AccountData {
    private String username;
    private String mail;
    private Long phoneNumber;
    private String password;
}
