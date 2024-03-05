package pl.gucio.enzo.chronica.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gucio.enzo.chronica.user.logic.LinkService;

@RestController
@RequestMapping(path = "/api/link")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;
    @GetMapping(value = "/confirmation/{generatedCode}")
    public ResponseEntity<?> confirmAccount(@PathVariable String generatedCode) {
        linkService.confirmAccount(generatedCode);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
