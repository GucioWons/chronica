package pl.gucio.enzo.chronica.user.logic;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.entity.LinkEntity;
import pl.gucio.enzo.chronica.user.data.repository.LinkRepository;
import pl.gucio.enzo.chronica.user.logic.basic.AccountBasicService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LinkService {
    private final LinkRepository linkRepository;
    private final AccountBasicService accountBasicService;
    private final Logger logger = LoggerFactory.getLogger(LinkService.class);
    public void createLinkForAccount(LinkEntity linkEntity) {
        linkRepository.save(linkEntity);
    }

    public List<LinkEntity> readAll(){
        return linkRepository.findAll();
    }

    @Transactional
    public void confirmAccount(String generatedVal){
        final LinkEntity linkEntity = linkRepository.findLinkEntityByGeneratedCode(generatedVal);
        final AccountEntity accountEntity = linkEntity.getAccount();

        accountEntity.setIsActive(true);
        accountBasicService.update(accountEntity);

        linkRepository.delete(linkEntity);
    }
    @Scheduled(fixedRate = 1800000)
    public void checkLinkExpiration() {
        final List<LinkEntity> links = readAll();
        final LocalDateTime now = LocalDateTime.now();

        logger.info("Deletion of inactive accounts: ");

        for (LinkEntity link : links) {
            if (link.getGeneratedAt().plusMinutes(link.getExpiryTime()).isBefore(now)) {
                accountBasicService.delete(link.getAccount().getId());
                logger.info(String.valueOf(link.getAccount().getId()));
            }
        }
    }
}
