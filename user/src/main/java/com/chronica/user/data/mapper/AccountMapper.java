package com.chronica.user.data.mapper;

import com.chronica.user.data.dto.AccountDTO;
import com.chronica.user.data.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {
    private final PersonMapper personMapper;

    public AccountDTO mapToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setMail(account.getMail());
        dto.setPhoneNumber(account.getPhoneNumber());
        dto.setActive(account.isActive());
        dto.setDeprecated(account.isDeprecated());
        dto.setRole(account.getRole());
        dto.setCreatedAt(account.getCreatedAt());
        dto.setPerson(personMapper.mapToDTO(account.getPerson()));
        return dto;
    }

    public Account mapToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setMail(accountDTO.getMail());
        account.setPhoneNumber(accountDTO.getPhoneNumber());
        account.setPassword(accountDTO.getPassword());
        account.setPerson(personMapper.mapToEntity(accountDTO.getPerson()));
        return account;
    }
}
