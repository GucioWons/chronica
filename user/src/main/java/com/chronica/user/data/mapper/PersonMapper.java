package com.chronica.user.data.mapper;

import org.chronica.library.commons.exception.NotImplementedException;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.user.dto.PersonDTO;
import com.chronica.user.data.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements BaseMapper<Person, PersonDTO> {
    @Override
    public PersonDTO mapToDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setLastName(person.getLastName());
        return dto;
    }

    @Override
    public Person mapToNewEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setLastName(personDTO.getLastName());
        return person;
    }

    //TODO updating person
    @Override
    public Person mapToUpdateEntity(Person toUpdate, PersonDTO dto) {
        throw new NotImplementedException();
    }
}
