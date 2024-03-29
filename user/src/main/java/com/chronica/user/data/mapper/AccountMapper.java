package com.chronica.user.data.mapper;

import com.chronica.user.data.dto.AccountDTO;
import com.chronica.user.data.entity.Account;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements  Mapper<Account, AccountDTO>{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AccountDTO mappToDTO(Account account) {
        return new AccountDTO(account.getId(), account.getUsername(), account.getMail(), account.getPhoneNumber(), account.getPassword(),
                            account.getIsActive(), account.getDeprecated(), account.getRole(), account.getCreatedAt());
    }

    @Override
    public Account mappToEntity(AccountDTO accountDTO) {
    final Account account = new Account();

    account.setUsername(accountDTO.username());
    account.setMail(accountDTO.mail());
    account.setPhoneNumber(accountDTO.phoneNumber());
    account.setPassword(bCryptPasswordEncoder.encode(accountDTO.password()));
    account.setIsActive(accountDTO.isActive());

    return account;
    }
}
