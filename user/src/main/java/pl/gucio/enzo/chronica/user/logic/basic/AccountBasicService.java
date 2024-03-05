package pl.gucio.enzo.chronica.user.logic.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountBasicService {
    private final AccountRepository accountRepository;

    public AccountEntity findAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
    public void update(AccountEntity accountEntity){
        accountRepository.save(accountEntity);
    }

    public void delete(Long id){
       final AccountEntity accountEntity = findAccountById(id);
       accountRepository.delete(accountEntity);
    }
}
