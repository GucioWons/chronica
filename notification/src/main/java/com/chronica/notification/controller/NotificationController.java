package com.chronica.notification.controller;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.record.PaginationAndSortDTO;
import com.chronica.notification.logic.NotificationMasterService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationMasterService notificationMasterService;

    @PostMapping(path = "")
    public ResponseEntity<BaseDTO> createNotification(@RequestBody BaseDTO request){
        return notificationMasterService.createNotification(request);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getNotification(@PathVariable Long id){
        return notificationMasterService.readNotification(id);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<BaseDTO>> getNotifications(@RequestBody PaginationAndSortDTO request){
        return notificationMasterService.getAllNotifications(request);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id){
        return notificationMasterService.deleteNotification(id);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<BaseDTO> updateNotification(@PathVariable Long id, @RequestBody BaseDTO request){
        return notificationMasterService.updateNotification(request,id);
    }
}
