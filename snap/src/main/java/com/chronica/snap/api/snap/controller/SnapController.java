package com.chronica.snap.api.snap.controller;

import com.chronica.snap.api.snap.dto.SnapDTO;
import com.chronica.snap.api.snap.logic.SnapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/snaps", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class SnapController {
    private final SnapService snapService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SnapDTO> getSnapById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(snapService.getSnapById(id));
    }

    @PostMapping
    public ResponseEntity<SnapDTO> createSnap(@RequestBody SnapDTO snap) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(snapService.createSnap(snap));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SnapDTO> updateSnap(@PathVariable Long id, @RequestBody SnapDTO snap) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(snapService.updateSnap(id, snap));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSnap(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(snapService.deprecateSnap(id));
    }
}
