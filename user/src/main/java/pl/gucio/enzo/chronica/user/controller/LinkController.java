package pl.gucio.enzo.chronica.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gucio.enzo.chronica.user.data.dto.response.AccountConfirmedResponseDto;
import pl.gucio.enzo.chronica.user.logic.LinkService;

@RestController
@RequestMapping(path = "/api/link")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;
    @GetMapping(value = "/confirmation/{generatedCode}")
    public ResponseEntity<AccountConfirmedResponseDto> confirmAccount(@PathVariable String generatedCode) {
        return linkService.confirmAccount(generatedCode);
    }
}
