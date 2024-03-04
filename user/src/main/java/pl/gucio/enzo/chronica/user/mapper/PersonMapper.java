package pl.gucio.enzo.chronica.user.mapper;


import org.mapstruct.Mapper;


import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.dto.PersonDto;

@Mapper
public interface PersonMapper {
    PersonEntity mappToEntity(PersonDto personDto);
    PersonDto mappToDto(PersonEntity personEntity);
}
