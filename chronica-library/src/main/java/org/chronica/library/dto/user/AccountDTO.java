package org.chronica.library.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;
import org.chronica.library.enumerated.UserRole;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO extends EntityDTO {
    private String username;
    private String mail;
    private Long phoneNumber;
    private String password;
    private List<UserRole> userRoles;
    private PersonDTO person;
}
