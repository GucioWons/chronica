package com.chronica.user

import com.chronica.user.api.account.data.AccountRepository
import com.chronica.user.api.account.entity.Account
import com.chronica.user.api.account.logic.AccountService
import com.chronica.user.api.account.mapper.AccountMapper
import org.chronica.library.dto.user.AccountDTO
import spock.lang.Specification
import spock.lang.Subject

class AccountServiceSpec extends Specification{

    AccountRepository accountRepository = Mock(AccountRepository)
    AccountMapper accountMapper = Mock(AccountMapper)


    @Subject
    AccountService accountService = new AccountService(accountRepository, accountMapper)

    def "should deprecate account when account exists"() {
        given:
        Long accountId = 1L
        Account account = new Account(id: accountId, deprecated: false)
        accountRepository.findById(accountId) >> Optional.of(account)

        when:
        String result = accountService.deleteAccount(accountId)

        then:
        1 * accountRepository.save(_ as Account) >> { Account acc ->
            assert acc.deprecated
            return acc
        }
        result == "Account has been deprecated"
    }

    def "should throw AccountDoesntExistException when account does not exist for deletion"() {
        given:
        Long accountId = 1L
        accountRepository.findById(accountId) >> Optional.empty()

        when:
        accountService.deleteAccount(accountId)

        then:
        thrown(NoAccountException)
    }

    def "should return account DTO when account exists"() {
        given:
        Long accountId = 1L
        Account account = new Account(id: accountId)
        AccountDTO accountDTO = new AccountDTO()
        accountRepository.findById(accountId) >> Optional.of(account)
        accountMapper.mapToDTO(account) >> accountDTO

        when:
        AccountDTO result = accountService.getAccountById(accountId)

        then:
        result == accountDTO
    }

    def "should throw AccountDoesntExistException when account does not exist for fetching by ID"() {
        given:
        Long accountId = 1L
        accountRepository.findById(accountId) >> Optional.empty()

        when:
        accountService.getAccountById(accountId)

        then:
        thrown(NoAccountException)
    }

    def "should return account when account exists and is active"() {
        given:
        String mail = "test@mail.com"
        Account account = new Account(mail: mail, active: true)
        accountRepository.findByMailAndActive(mail, true) >> Optional.of(account)

        when:
        Account result = accountService.getAccountByMailAndEnabled(mail)

        then:
        result == account
    }

    def "should throw WrongCredentialsException when account does not exist or is not active"() {
        given:
        String mail = "test@mail.com"
        accountRepository.findByMailAndActive(mail, true) >> Optional.empty()

        when:
        accountService.getAccountByMailAndEnabled(mail)

        then:
        thrown(WrongCredentialsException)
    }
}

