package com.chronica.user

import com.chronica.user.data.entity.Account
import com.chronica.user.data.entity.Link
import com.chronica.user.data.mapper.LinkConfirmationMapper
import com.chronica.user.data.repository.AccountRepository
import com.chronica.user.data.repository.LinkRepository
import com.chronica.user.logic.LinkService
import org.chronica.library.dto.user.LinkConfirmationDTO
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDateTime

class LinkServiceSpec extends Specification {

    LinkRepository linkRepository = Mock(LinkRepository)
    AccountRepository accountRepository = Mock(AccountRepository)
    LinkConfirmationMapper linkConfirmationMapper = Mock(LinkConfirmationMapper)

    @Subject
    LinkService linkService = new LinkService(linkRepository, accountRepository, linkConfirmationMapper)

    def "should create link for account"() {
        given:
        Link link = new Link()

        when:
        linkService.createLinkForAccount(link)

        then:
        1 * linkRepository.save(link)
    }

    def "should confirm account and return LinkConfirmationDTO"() {
        given:
        String generatedVal = "generatedCode"
        Link link = Mock(Link)
        Account account = Mock(Account)
        String mail = "user@mail.com"
        LinkConfirmationDTO expectedDTO = new LinkConfirmationDTO(mail, true, LocalDateTime.now())

        linkRepository.findLinkEntityByGeneratedCode(generatedVal) >> link
        link.getAccount() >> account
        account.getMail() >> mail
        linkConfirmationMapper.mapToDTO(mail, true, _ as LocalDateTime) >> expectedDTO

        when:
        LinkConfirmationDTO result = linkService.confirmAccount(generatedVal)

        then:
        1 * account.setActive(true)
        1 * accountRepository.save(account)
        1 * link.setDeprecated(true)
        1 * linkRepository.save(link)
        result == expectedDTO
    }

    def "should deprecate expired links"() {
        given:
        LocalDateTime now = LocalDateTime.now()
        Link link1 = Mock(Link)

        link1.getGeneratedAt() >> now.minusMinutes(61)
        link1.getExpirationTime() >> 60


        linkRepository.findAll() >> [link1]

        when:
        linkService.checkLinkExpiration()

        then:
        1 * link1.setDeprecated(true)
        1 * linkRepository.save(link1)
    }

    def "should return all links"() {
        given:
        List<Link> links = [new Link(), new Link()]
        linkRepository.findAll() >> links

        when:
        List<Link> result = linkService.getAll()

        then:
        result == links
    }
}
