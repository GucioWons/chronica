package com.chronica.user.logic;

import com.chronica.user.data.entity.Account;
import org.chronica.library.exception.user.NoAccountException;
import org.chronica.library.exception.user.WrongCredentialsException;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public String deleteAccount(Long id) {
        return accountRepository.findById(id)
                .map(this::deprecateAccount)
                .orElseThrow(() -> new NoAccountException("Account not found"));
    }

    private String deprecateAccount(Account account) {
        account.setDeprecated(true);
        accountRepository.save(account);
        return "Account has been deprecated";
    }

    public AccountDTO getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::mapToDTO)
                .orElseThrow(() -> new NoAccountException("Account not found"));
    }

    public Account getAccountByMailAndEnabled(String mail) {
        return accountRepository.findByMailAndActive(mail, true)
                .orElseThrow(() -> new WrongCredentialsException("Wrong mail ! Try again"));
    }
}
