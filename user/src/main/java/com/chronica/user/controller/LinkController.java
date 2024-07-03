package com.chronica.user.controller;

import org.chronica.library.user.dto.LinkConfirmationDTO;
import com.chronica.user.logic.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/links")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @GetMapping(value = "/confirmation/{generatedCode}")
    public ResponseEntity<LinkConfirmationDTO> confirmAccount(@PathVariable String generatedCode) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.confirmAccount(generatedCode));
    }
}
