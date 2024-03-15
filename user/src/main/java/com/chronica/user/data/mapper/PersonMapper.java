package com.chronica.user.data.mapper;

import com.chronica.user.data.dto.PersonDTO;
import com.chronica.user.data.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<Person, PersonDTO> {
    @Override
    public PersonDTO mappToDTO(Person person) {
        return new PersonDTO(person.getId(), person.getName(), person.getLastName(), person.getAge());
    }

    @Override
    public Person mappToEntity(PersonDTO personDTO) {
        Person person = new Person();

        person.setName(personDTO.name());
        person.setLastName(personDTO.lastName());
        person.setAge(person.getAge());

        return person;
    }
}
