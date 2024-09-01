package com.chronica.user.data.mapper;

import com.chronica.user.data.entity.Person;
import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.user.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PersonMapper implements BaseMapper<Person, PersonDTO> {
    public abstract PersonDTO mapToDTO(Person person);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "account", ignore = true)
    public abstract Person mapToNewEntity(PersonDTO personDTO);

    //TODO updating person
    public Person mapToUpdateEntity(Person toUpdate, PersonDTO dto) {
        throw new NotImplementedException();
    }
}
