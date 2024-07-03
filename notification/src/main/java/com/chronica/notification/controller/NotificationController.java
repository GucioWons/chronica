package com.chronica.notification.controller;

import org.chronica.library.notification.dto.NotificationDTO;
import org.chronica.library.dto.PaginationAndSortDTO;
import com.chronica.notification.logic.ServiceMajorNotification;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class NotificationController {
    private final ServiceMajorNotification serviceMajorNotification;

    @PostMapping(path = "")
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO request){
        return serviceMajorNotification.createNotification(request);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<NotificationDTO> getNotification(@PathVariable Long id){
        return serviceMajorNotification.readNotification(id);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<NotificationDTO>> getNotifications(@RequestBody PaginationAndSortDTO request){
        return serviceMajorNotification.getAllNotifications(request);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id){
        return serviceMajorNotification.deleteNotification(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id, @RequestBody NotificationDTO request){
        return serviceMajorNotification.updateNotification(request,id);
    }
}
