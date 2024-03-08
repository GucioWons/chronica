package pl.gucio.enzo.chronica.user.logic.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.Account;
import pl.gucio.enzo.chronica.user.data.repository.AccountRepository;
import pl.gucio.enzo.chronica.user.logic.exception.AccountDoesntExistException;
import pl.gucio.enzo.chronica.user.logic.exception.WrongCredentialsException;

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
