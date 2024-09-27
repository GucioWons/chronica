package com.chronica.user.api.account.mapper;

import com.chronica.user.api.account.entity.Person;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.dto.user.PersonDTO;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
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
        throw new ChronicaException(ErrorMessage.NOT_IMPLEMENTED_EXCEPTION);
    }
}
