package com.chronica.user.api.link.controller;

import com.chronica.user.api.link.logic.LinkService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.user.LinkConfirmationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/links")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @GetMapping(value = "/confirm/{generatedCode}")
    public ResponseEntity<LinkConfirmationDTO> confirmAccount(@PathVariable String generatedCode) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.confirmAccount(generatedCode));
    }
}
