package pl.gucio.enzo.chronica.user.mapper;

import org.mapstruct.Mapper;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.dto.AccountDto;

@Mapper
public interface AccountMapper {

    AccountEntity mappToEntity(AccountDto accountDto);
    AccountDto mappToDto(AccountEntity accountEntity);
}
