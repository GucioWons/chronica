package com.chronica.notification.controller;

import org.chronica.library.commons.dto.PaginationAndSortDTO;
import com.chronica.notification.logic.service.MajorNotificationService;

import lombok.RequiredArgsConstructor;

import org.chronica.library.dto.notification.NotificationDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class NotificationController {
    private final MajorNotificationService majorNotificationService;

    @PostMapping(path = "")
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO request) {
        return majorNotificationService.createNotification(request);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<NotificationDTO> getNotification(@PathVariable Long id) {
        return majorNotificationService.readNotification(id);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<NotificationDTO>> getNotifications() {
        return majorNotificationService.getAllNotifications();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        return majorNotificationService.deleteNotification(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id, @RequestBody NotificationDTO request) {
        return majorNotificationService.updateNotification(request, id);
    }
}
