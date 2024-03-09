package com.chronica.user.logic.basic;

import com.chronica.user.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.chronica.user.data.entity.Account;
import com.chronica.user.data.exception.AccountDoesntExistException;
import com.chronica.user.data.exception.WrongCredentialsException;

@Service
@RequiredArgsConstructor
public class AccountBasicService {
    private final AccountRepository accountRepository;

    public Account findAccountById(Long id){
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountDoesntExistException("Account not found"));
    }

    public Account findAccountByMail(String mail){
        return accountRepository
                .findAccountByMail(mail)
                .orElseThrow(() -> new AccountDoesntExistException("Account not found"));
    }

    public void update(Account account){
        accountRepository.save(account);
    }
    
    public Account findAccountByMailAndEnabled(String mail){
        return accountRepository.findAccountEntityByMailAndIsActive(mail,true)
                .orElseThrow(() -> new WrongCredentialsException("Wrong mail ! Try again"));
    }


}
