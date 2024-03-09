package com.chronica.notification.controller;


import com.chronica.notification.data.dto.request.CreateNoticeRequestDto;
import com.chronica.notification.data.dto.response.CreateNoticeResponseDto;
import com.chronica.notification.logic.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/notification", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class NotificationController {
    private final GlobalService globalService;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateNoticeResponseDto> createNotice(@RequestBody CreateNoticeRequestDto request){
        return globalService.createNotice(request);
    }
}
