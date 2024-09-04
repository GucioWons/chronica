package com.chronica.group.controller;


import com.chronica.group.logic.GroupService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.group.GroupDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/groups")
@RequiredArgsConstructor
@RestController
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDTO> createGroup(GroupDTO toSave) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(groupService.createGroup(toSave));
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getGroups() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.getGroups());
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable("groupId") Long groupId) {
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(groupService.getGroupById(groupId));
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<GroupDTO> updateGroup(@PathVariable("groupId") Long groupId, GroupDTO toUpdate) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.updateGroup(groupId, toUpdate));
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable("groupId") Long groupId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.deprecateGroup(groupId));
    }
}
