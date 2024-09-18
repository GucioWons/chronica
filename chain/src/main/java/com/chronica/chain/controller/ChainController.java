package com.chronica.chain.controller;

import com.chronica.chain.logic.ChainOptionsService;
import com.chronica.chain.logic.ChainService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.chain.ChainDTO;
import org.chronica.library.dto.chain.ChainSelectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/chains", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class ChainController {
    private final ChainService chainService;
    private final ChainOptionsService chainOptionsService;

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

    @GetMapping
    public ResponseEntity<List<ChainDTO>> getChains() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.getChains());
    }

    @PutMapping("/{chainId}")
    public ResponseEntity<ChainDTO> updateChain(@PathVariable("chainId") Long chainId, @RequestBody ChainDTO chainDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.updateChainById(chainId, chainDto));
    }

    @GetMapping("/options")
    public ResponseEntity<List<ChainSelectDTO>> getChainsOptions() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainOptionsService.getChainSelects());
    }

    @DeleteMapping("/{chainId}")
    public ResponseEntity<String> deleteChain(@PathVariable("chainId") Long chainId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chainService.deleteChainById(chainId));
    }
}
