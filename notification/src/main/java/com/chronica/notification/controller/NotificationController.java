package com.chronica.notification.controller;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.dto.record.PaginationAndSortDTO;
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
    public ResponseEntity<BaseDTO> createNotification(@RequestBody BaseDTO request){
        return serviceMajorNotification.createNotification(request);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BaseDTO> getNotification(@PathVariable Long id){
        return serviceMajorNotification.readNotification(id);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<BaseDTO>> getNotifications(@RequestBody PaginationAndSortDTO request){
        return serviceMajorNotification.getAllNotifications(request);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id){
        return serviceMajorNotification.deleteNotification(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaseDTO> updateNotification(@PathVariable Long id, @RequestBody BaseDTO request){
        return serviceMajorNotification.updateNotification(request,id);
    }
}
