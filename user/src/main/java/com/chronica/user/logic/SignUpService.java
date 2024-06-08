package com.chronica.user.logic;

import com.chronica.user.data.dto.AccountDTO;
import com.chronica.user.data.entity.Account;
import com.chronica.user.data.entity.Link;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.data.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final AccountRepository accountRepository;
    private final EmailService emailService;
    private final LinkService linkService;
    private final AccountMapper accountMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public AccountDTO signUp(AccountDTO dto) {
        Account account = accountMapper.mapToEntity(dto);
        account.setPassword(bCryptPasswordEncoder.encode(dto.getPassword() + dto.getMail()));
        accountRepository.save(account);

        Link linkEntity = new Link();
        linkEntity.setAccount(account);
        linkService.createLinkForAccount(linkEntity);

        emailService.sendConfirmationEmail(account.getMail(), "Welcome: Account Confirmation", linkEntity.getGeneratedCode());

        return accountMapper.mapToDTO(account);
    }
}
