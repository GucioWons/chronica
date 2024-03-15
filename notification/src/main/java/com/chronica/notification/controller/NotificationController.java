package com.chronica.notification.controller;

import com.chronica.notification.data.dto.NotificationDTO;
import com.chronica.notification.data.dto.QueryNotificationDTO;
import com.chronica.notification.logic.NotificationMasterService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationMasterService notificationMasterService;

    @PostMapping(path = "")
    public ResponseEntity<NotificationDTO> createNotice(@RequestBody NotificationDTO request){
        return notificationMasterService.createNotice(request);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> readNotice(@PathVariable Long id){
        return notificationMasterService.readNotice(id);
    }

    @PostMapping(path = "/query-all")
    public ResponseEntity<QueryNotificationDTO> queryNotices(@RequestBody QueryNotificationDTO filter){
        return notificationMasterService.queryAll(filter);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> queryNotices(@PathVariable Long id){
        return notificationMasterService.deleteNotice(id);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<NotificationDTO> updateNotice(@PathVariable Long id, @RequestBody NotificationDTO request){
        return notificationMasterService.updateNotice(request,id);
    }
}
