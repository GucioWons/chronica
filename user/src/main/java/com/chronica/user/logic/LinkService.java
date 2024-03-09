package com.chronica.user.logic;

import com.chronica.user.data.entity.Account;
import com.chronica.user.data.entity.Link;
import com.chronica.user.data.repository.LinkRepository;
import com.chronica.user.logic.basic.AccountBasicService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.chronica.user.data.dto.response.AccountConfirmedResponseDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;
    private final AccountBasicService accountBasicService;
    public void createLinkForAccount(Link link) {
        linkRepository.save(link);
    }

    public List<Link> readAll(){
        return linkRepository.findAll();
    }

    @Transactional
    public ResponseEntity<AccountConfirmedResponseDto> confirmAccount(String generatedVal){
        final Link link = linkRepository.findLinkEntityByGeneratedCode(generatedVal);
        final Account account = link.getAccount();

        account.setIsActive(true);
        accountBasicService.update(account);

        link.setDeprecated(true);
        linkRepository.save(link);

        final AccountConfirmedResponseDto response = new AccountConfirmedResponseDto(account.getMail(),true,LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
    @Scheduled(fixedRate = 1800000)
    public void checkLinkExpiration() {
        final List<Link> links = readAll();
        final LocalDateTime now = LocalDateTime.now();

        for (Link link : links) {
            if (link.getGeneratedAt().plusMinutes(link.getExpirationTime()).isBefore(now)) {
                final Account account = link.getAccount();

                account.setDeprecated(true);
                link.setDeprecated(true);

                accountBasicService.update(account);
                linkRepository.save(link);
            }
        }
    }
}
