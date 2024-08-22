package com.chronica.user.controller;

import org.chronica.library.user.dto.LinkConfirmationDTO;
import com.chronica.user.logic.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/links")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LinkController {
    private final LinkService linkService;

    @GetMapping(value = "/confirmation/{generatedCode}")
    public ResponseEntity<LinkConfirmationDTO> confirmAccount(@PathVariable String generatedCode) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.confirmAccount(generatedCode));
    }
}
