package org.chronica.library.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.dto.EntityDTO;
import org.chronica.library.user.enumerated.Role;

import java.time.LocalDateTime;
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
    private boolean isActive;
    private Boolean deprecated;
    private List<Role> roles;
    private LocalDateTime createdAt;
    private PersonDTO person;
}
