package com.chronica.user.logic;

import com.chronica.user.data.entity.Account;
import com.chronica.user.data.entity.Link;
import com.chronica.user.data.mapper.AccountMapper;
import com.chronica.user.data.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.enumerated.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

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
        Account account = accountMapper.mapToNewEntity(dto);
        account.setPassword(bCryptPasswordEncoder.encode(dto.getPassword() + dto.getMail()));
        account.setUserRoles(Collections.singletonList(UserRole.USER));
        accountRepository.save(account);
        Link linkEntity = new Link();
        linkEntity.setAccount(account);
        linkService.createLinkForAccount(linkEntity);

        emailService.sendConfirmationEmail(account.getMail(), "Welcome: Account Confirmation", linkEntity.getGeneratedCode());

        return accountMapper.mapToDTO(account);
    }
}
