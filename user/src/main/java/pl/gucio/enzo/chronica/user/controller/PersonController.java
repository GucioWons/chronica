package pl.gucio.enzo.chronica.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gucio.enzo.chronica.user.logic.PersonApi;
import pl.gucio.enzo.chronica.user.logic.basic.PersonService;

@RestController
@RequestMapping(path = "/api/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonApi personApi;
}
