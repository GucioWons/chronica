package com.chronica.user.data.mapper;

import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.user.dto.AccountDTO;
import com.chronica.user.data.entity.Account;
import lombok.RequiredArgsConstructor;
import org.chronica.library.user.enumerated.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountMapper implements BaseMapper<Account, AccountDTO> {
    private final PersonMapper personMapper;

    @Override
    public AccountDTO mapToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setMail(account.getMail());
        dto.setPhoneNumber(account.getPhoneNumber());
        dto.setActive(account.isActive());
        dto.setDeprecated(account.isDeprecated());
        dto.setRoles(account.getRoles());
        dto.setCreatedAt(account.getCreatedAt());
        dto.setPerson(personMapper.mapToDTO(account.getPerson()));
        return dto;
    }

    @Override
    public Account mapToNewEntity(AccountDTO accountDTO) {
        Account account = new Account();
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);
        account.setUsername(accountDTO.getUsername());
        account.setMail(accountDTO.getMail());
        account.setPhoneNumber(accountDTO.getPhoneNumber());
        account.setPassword(accountDTO.getPassword());
        account.setRoles(roles);
        account.setPerson(personMapper.mapToNewEntity(accountDTO.getPerson()));
        return account;
    }


    @Override
    public Account mapToUpdateEntity(Account toUpdate, AccountDTO dto) {
        throw new NotImplementedException();
    }
}
