package pl.gucio.enzo.chronica.user.domain.mapper;

import org.mapstruct.Mapper;
import pl.gucio.enzo.chronica.user.domain.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.domain.model.AccountData;

@Mapper
public interface AccountMapper {
    AccountEntity mappToEntity(AccountData accountData);
    AccountData mappToDto(AccountEntity accountEntity);
}
