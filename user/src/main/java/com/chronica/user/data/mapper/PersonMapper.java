package com.chronica.user.data.mapper;

import org.chronica.library.user.dto.PersonDTO;
import com.chronica.user.data.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonDTO mapToDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setLastName(person.getLastName());
        dto.setAge(person.getAge());
        return dto;
    }

    public Person mapToEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setLastName(personDTO.getLastName());
        person.setAge(personDTO.getAge());
        return person;
    }
}
