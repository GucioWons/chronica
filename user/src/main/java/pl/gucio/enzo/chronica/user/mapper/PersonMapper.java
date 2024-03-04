package pl.gucio.enzo.chronica.user.mapper;


import org.mapstruct.Mapper;


import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.model.PersonalInformation;

@Mapper
public interface PersonMapper {
    PersonEntity mappToEntity(PersonalInformation personalInformation);
    PersonalInformation mappToDto(PersonEntity personEntity);
}
