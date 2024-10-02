package com.chronica.user.api.account.logic;

import com.chronica.user.api.account.data.AccountRepository;
import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.mapper.AccountMapper;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.NoEntityException;
import lombok.RequiredArgsConstructor;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public String deleteAccount(Long id) {
        return accountRepository.findById(id)
                .map(this::deprecateAccount)
                .orElseThrow(() -> new NoEntityException(Account.class.getSimpleName(), id));
    }

    private String deprecateAccount(Account account) {
        account.setDeprecated(true);
        accountRepository.save(account);
        return "Account has been deprecated";
    }

    public AccountDTO getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::mapToDTO)
                .orElseThrow(() -> new NoEntityException(Account.class.getSimpleName(), id));
    }

    public Account getAccountByMailAndEnabled(String mail) {
        return accountRepository.findByMailAndActive(mail, true)
                .orElseThrow(() -> new ChronicaException(ErrorMessage.AUTHORIZATION_EXCEPTION));
    }
}
