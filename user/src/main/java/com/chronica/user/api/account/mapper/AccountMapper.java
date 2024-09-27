package com.chronica.user.api.account.mapper;

import com.chronica.user.api.account.entity.Account;
import com.chronica.user.api.account.mapper.PersonMapper;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.user.AccountDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = PersonMapper.class
)
public abstract class AccountMapper implements BaseMapper<Account, AccountDTO> {

    public abstract AccountDTO mapToDTO(Account account);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Account mapToNewEntity(AccountDTO accountDTO);

    //TODO updating account
    @Override
    public Account mapToUpdateEntity(Account toUpdate, AccountDTO dto) {
        throw new ChronicaException(ErrorMessage.NOT_IMPLEMENTED_EXCEPTION);
    }
}
