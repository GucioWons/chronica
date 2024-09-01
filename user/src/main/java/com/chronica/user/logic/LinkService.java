package com.chronica.user.logic;

import com.chronica.user.data.entity.Account;
import com.chronica.user.data.entity.Link;
import com.chronica.user.data.mapper.LinkConfirmationMapper;
import com.chronica.user.data.repository.AccountRepository;
import com.chronica.user.data.repository.LinkRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.LinkConfirmationDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;
    private final AccountRepository accountRepository;
    private final LinkConfirmationMapper linkConfirmationMapper;

    public void createLinkForAccount(Link link) {
        linkRepository.save(link);
    }

    @Transactional
    public LinkConfirmationDTO confirmAccount(String generatedVal) {
        Link link = linkRepository.findLinkEntityByGeneratedCode(generatedVal);
        Account account = link.getAccount();

        account.setActive(true);
        accountRepository.save(account);

        link.setDeprecated(true);
        linkRepository.save(link);

        return linkConfirmationMapper.mapToDTO(account.getMail(), true, LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1800000)
    public void checkLinkExpiration() {
        getAll().stream()
                .filter(link -> link.getGeneratedAt().plusMinutes(link.getExpirationTime()).isBefore(LocalDateTime.now()))
                .forEach(this::deprecateLink);
    }

    private List<Link> getAll() {
        return linkRepository.findAll();
    }

    private void deprecateLink(Link link) {
        link.setDeprecated(true);
        linkRepository.save(link);
    }
}
