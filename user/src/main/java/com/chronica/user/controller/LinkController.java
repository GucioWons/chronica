package com.chronica.user.controller;

import com.chronica.user.logic.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chronica.user.data.dto.response.AccountConfirmedResponseDto;

@RestController
@RequestMapping(path = "/api/links")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;
    @GetMapping(value = "/confirmation/{generatedCode}")
    public ResponseEntity<AccountConfirmedResponseDto> confirmAccount(@PathVariable String generatedCode) {
        return linkService.confirmAccount(generatedCode);
    }
}
