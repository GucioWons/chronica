package com.chronica.notification.controller;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.PaginationAndSortDTO;
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
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO request){
        return notificationMasterService.createNotice(request);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getNotification(@PathVariable Long id){
        return notificationMasterService.readNotice(id);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<NotificationDTO>> getNotifications(@RequestBody PaginationAndSortDTO request){
        return notificationMasterService.queryAll(request);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id){
        return notificationMasterService.deleteNotice(id);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id, @RequestBody NotificationDTO request){
        return notificationMasterService.updateNotice(request,id);
    }
}
