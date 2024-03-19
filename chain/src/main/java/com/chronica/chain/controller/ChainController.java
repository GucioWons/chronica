package com.chronica.chain.controller;

import com.chronica.chain.entity.Chain;
import com.chronica.chain.logic.ChainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/chains", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class ChainController {
    private final ChainService chainService;

    @PostMapping
    public ResponseEntity<Chain> createChain(@RequestBody Chain chain) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(chainService.createChain(chain));
    }

    @GetMapping("/{chainId}")
    public ResponseEntity<Chain> getChainById(@PathVariable("chainId") Long chainId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.getChainById(chainId));
    }
}
