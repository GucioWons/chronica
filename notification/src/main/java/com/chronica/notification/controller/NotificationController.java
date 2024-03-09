package com.chronica.notification.controller;


import com.chronica.notification.data.dto.request.CreateNoticeRequestDto;
import com.chronica.notification.data.dto.request.QueryNoticeRequestDto;
import com.chronica.notification.data.dto.request.UpdateNoticeRequestDto;
import com.chronica.notification.data.dto.response.*;
import com.chronica.notification.logic.NotificationApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/notifications", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationApi notificationApi;

    @PostMapping(path = "/create")
    public ResponseEntity<CreateNoticeResponseDto> createNotice(@RequestBody CreateNoticeRequestDto request){
        return notificationApi.createNotice(request);
    }

    @GetMapping(path = "/read/{id}")
    public ResponseEntity<ReadNoticeResponseDto> readNotice(@PathVariable Long id){
        return notificationApi.readNotice(id);
    }

    @PostMapping(path = "/query-all")
    public ResponseEntity<QueryNoticeResponseDto> queryNotices(@RequestBody QueryNoticeRequestDto filter){
        return notificationApi.queryAll(filter);
    }

    @GetMapping(path = "/delete/{id}")
    public ResponseEntity<DeprecateNoticeResponseDto> queryNotices(@PathVariable Long id){
        return notificationApi.deleteNotice(id);
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<UpdateNoticeResponseDto> updateNotice(@PathVariable Long id,@RequestBody UpdateNoticeRequestDto request){
        return notificationApi.updateNotice(request,id);
    }
}
