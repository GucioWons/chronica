package com.chronica.user

import com.chronica.user.api.auth.signin.logic.SignInService
import com.chronica.user.api.account.entity.Account
import com.chronica.user.api.account.logic.AccountService
import com.chronica.user.api.account.mapper.AccountMapper
import org.chronica.library.dto.user.AccountDTO
import org.chronica.library.dto.user.SignInDTO
import org.chronica.library.dto.user.SignInResultDTO
import org.chronica.library.exception.ChronicaException
import org.chronica.library.exception.dto.enumerated.ErrorMessage
import org.chronica.library.security.JWTHandler
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class SignInServiceSpec extends Specification {

    AccountService accountService = Mock(AccountService)
    JWTHandler jwtHandler = Mock(JWTHandler)
    BCryptPasswordEncoder bCryptPasswordEncoder = Mock(BCryptPasswordEncoder)
    AccountMapper accountMapper = Mock(AccountMapper)

    @Subject
    SignInService signInService = new SignInService(accountService, jwtHandler, bCryptPasswordEncoder, accountMapper)

    def "should return SignInHelper when credentials are correct"() {
        given:
        String mail = "user@mail.com"
        String password = "password123"
        String encodedPassword = "encodedPassword"
        SignInDTO signInRequest = new SignInDTO(mail, password)
        Account account = new Account(mail: mail, password: encodedPassword)
        AccountDTO accountDTO = new AccountDTO()
        String token = "generatedToken"

        accountService.getAccountByMailAndEnabled(mail) >> account
        bCryptPasswordEncoder.matches(password + mail, encodedPassword) >> true
        jwtHandler.generateToken(mail) >> token
        accountMapper.mapToDTO(account) >> accountDTO

        when:
        Optional<SignInResultDTO> result = signInService.signIn(signInRequest)

        then:
        result.isPresent()
        result.get().token == token
        result.get().account == accountDTO
    }

    def "should return empty Optional when credentials are incorrect"() {
        given:
        String mail = "user@mail.com"
        String password = "wrongPassword"
        String encodedPassword = "encodedPassword"
        SignInDTO signInRequest = new SignInDTO(mail, password)
        Account account = new Account(mail: mail, password: encodedPassword)

        accountService.getAccountByMailAndEnabled(mail) >> account
        bCryptPasswordEncoder.matches(password + mail, encodedPassword) >> false

        when:
        Optional<SignInResultDTO> result = signInService.signIn(signInRequest)

        then:
        !result.isPresent()
    }

    def "should throw WrongCredentialsException when account does not exist"() {
        given:
        String mail = "nonexistent@mail.com"
        String password = "password123"
        SignInDTO signInRequest = new SignInDTO(mail, password)

        accountService.getAccountByMailAndEnabled(mail) >> { throw new ChronicaException(ErrorMessage.AUTHORIZATION_EXCEPTION) }

        when:
        signInService.signIn(signInRequest)

        then:
        thrown(WrongCredentialsException)
    }

    @Unroll
    def "should return #expectedResult when checking password with password: #password and encodedPassword: #encodedPassword"() {
        given:
        bCryptPasswordEncoder.matches(password, encodedPassword) >> matchesResult

        when:
        boolean result = signInService.checkPassword(password, encodedPassword)

        then:
        result == expectedResult

        where:
        password          | encodedPassword   | matchesResult || expectedResult
        "password123"     | "encodedPassword" | true          || true
        "wrongPassword"   | "encodedPassword" | false         || false
    }
}
