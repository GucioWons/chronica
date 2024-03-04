package pl.gucio.enzo.chronica.user.logic.basic;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.data.entity.AccountEntity;
import pl.gucio.enzo.chronica.user.data.entity.PersonEntity;
import pl.gucio.enzo.chronica.user.data.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public void create(PersonEntity person){
        personRepository.save(person);
    }
}
