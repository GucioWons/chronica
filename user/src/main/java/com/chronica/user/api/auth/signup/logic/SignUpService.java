package com.chronica.user.api.auth.signup.logic;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.auth.link.entity.Link;
import com.chronica.user.api.account.mapper.AccountMapper;
import com.chronica.user.api.account.data.AccountRepository;
import com.chronica.user.api.auth.link.logic.EmailService;
import com.chronica.user.api.auth.link.logic.LinkService;
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
