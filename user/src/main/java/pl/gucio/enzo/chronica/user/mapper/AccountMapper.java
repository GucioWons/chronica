package pl.gucio.enzo.chronica.user.mapper;

import org.mapstruct.Mapper;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.model.AccountData;

@Mapper
public interface AccountMapper {
    AccountEntity mappToEntity(AccountData accountData);
    AccountData mappToDto(AccountEntity accountEntity);
}
