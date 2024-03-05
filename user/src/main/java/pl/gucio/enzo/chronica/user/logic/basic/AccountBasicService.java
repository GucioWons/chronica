package pl.gucio.enzo.chronica.user.logic.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.repository.AccountRepository;
import pl.gucio.enzo.chronica.user.logic.exception.AccountDoesntExistException;
import pl.gucio.enzo.chronica.user.logic.exception.WrongCredentialsException;

@Service
@RequiredArgsConstructor
public class AccountBasicService {
    private final AccountRepository accountRepository;

    public AccountEntity findAccountById(Long id){
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountDoesntExistException("Account not found"));
    }

    public AccountEntity findAccountByMail(String mail){
        return accountRepository
                .findAccountByMail(mail)
                .orElseThrow(() -> new AccountDoesntExistException("Account not found"));
    }

    public void update(AccountEntity accountEntity){
        accountRepository.save(accountEntity);
    }

    public void delete(Long id){
       final AccountEntity accountEntity = findAccountById(id);
       accountRepository.delete(accountEntity);
    }

    public AccountEntity findAccountByMailAndEnabled(String mail){
        return accountRepository.findAccountEntityByMailAndIsActive(mail,true)
                .orElseThrow(() -> new WrongCredentialsException("Wrong mail ! Try again"));
    }


}
