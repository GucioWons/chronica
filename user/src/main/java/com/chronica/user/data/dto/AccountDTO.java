package com.chronica.user.data.dto;

import com.chronica.user.data.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.dto.EntityDTO;

import java.time.LocalDateTime;

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
    private Role role;
    private LocalDateTime createdAt;
    private PersonDTO person;
}
