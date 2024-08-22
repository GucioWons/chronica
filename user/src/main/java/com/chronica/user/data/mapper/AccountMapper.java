package com.chronica.user.data.mapper;

import com.chronica.user.data.entity.Account;
import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.user.dto.AccountDTO;
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
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public abstract Account mapToNewEntity(AccountDTO accountDTO);

    //TODO updating account
    @Override
    public Account mapToUpdateEntity(Account toUpdate, AccountDTO dto) {
        throw new NotImplementedException();
    }
}
