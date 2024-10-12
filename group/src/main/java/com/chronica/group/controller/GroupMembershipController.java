package com.chronica.group.controller;

import com.chronica.group.logic.GroupMembershipService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.group.GroupDTO;
import org.chronica.library.dto.group.GroupInvitationDTO;
import org.chronica.library.dto.group.GroupMemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/api/groups-memberships")
@RequiredArgsConstructor
@RestController
public class GroupMembershipController {
    private final GroupMembershipService groupMembershipService;

    @PostMapping("/{groupId}")
    public ResponseEntity<GroupInvitationDTO> sendInvitationToGroup(@RequestBody GroupInvitationDTO request, @PathVariable Long groupId, HttpServletRequest req){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupMembershipService.sendInvitationToGroup(request, groupId, req));
    }

    @PutMapping("/{groupId}/{invitedUserId}")
    public ResponseEntity<GroupInvitationDTO> acceptInvitationToGroup(@PathVariable Long groupId, @PathVariable Long invitedUserId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupMembershipService.acceptInvitationToGroup(invitedUserId,groupId));
    }

    @GetMapping("/{groupId}/members")
    public ResponseEntity<Set<GroupMemberDTO>> getGroupAllMembers(@PathVariable Long groupId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupMembershipService.getGroupAllMembers(groupId));

    }

    @GetMapping("/{userId}/groups")
    public ResponseEntity<Set<GroupDTO>> getMemberGroups(@PathVariable Long userId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupMembershipService.getMemberGroups(userId));

    }
}
