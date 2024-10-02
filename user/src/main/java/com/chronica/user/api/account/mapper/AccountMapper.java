package com.chronica.user.api.account.mapper;

import com.chronica.user.api.account.entity.Account;
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
    @Mapping(target = "password", ignore = true)
    public abstract AccountDTO mapToDTO(Account user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    public abstract Account mapToNewEntity(AccountDTO userDTO);

    //TODO updating user
    @Override
    public Account mapToUpdateEntity(Account toUpdate, AccountDTO dto) {
        throw new ChronicaException(ErrorMessage.NOT_IMPLEMENTED_EXCEPTION);
    }
}
