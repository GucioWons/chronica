package pl.gucio.enzo.chronica.user.domain.mapper;


import org.mapstruct.Mapper;

import pl.gucio.enzo.chronica.user.domain.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.domain.model.PersonalInformation;

@Mapper
public interface PersonMapper {
    PersonEntity mappToEntity(PersonalInformation personalInformation);
    PersonalInformation mappToDto(PersonEntity personEntity);
}
