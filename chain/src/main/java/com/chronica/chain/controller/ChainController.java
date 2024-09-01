package com.chronica.chain.controller;

import com.chronica.chain.logic.ChainService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.chain.ChainDTO;
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
    public ResponseEntity<ChainDTO> createChain(@RequestBody ChainDTO chain) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(chainService.createChain(chain));
    }

    @GetMapping("/{chainId}")
    public ResponseEntity<ChainDTO> getChainById(@PathVariable("chainId") Long chainId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.getChainById(chainId));
    }

    @PutMapping("/{chainId}")
    public ResponseEntity<ChainDTO> updateChain(@PathVariable("chainId") Long chainId, @RequestBody ChainDTO chainDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.updateChainById(chainId, chainDto));
    }

    @DeleteMapping("/{chainId}")
    public ResponseEntity<String> deleteChain(@PathVariable("chainId") Long chainId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.deleteChainById(chainId));
    }
}
