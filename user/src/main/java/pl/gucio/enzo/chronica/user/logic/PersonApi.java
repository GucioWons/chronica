package pl.gucio.enzo.chronica.user.logic;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gucio.enzo.chronica.user.logic.basic.PersonService;

@Service
@RequiredArgsConstructor
public class PersonApi {
    private final PersonService personService;
}
