package com.chronica.notification.data.entity;


import com.chronica.notification.data.constant.NotificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@RequiredArgsConstructor
@Setter
@Getter
@MappedSuperclass
public abstract class NotificationAbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime openAt;
    private Boolean deprecated = false;
    private Long receiverId;
}
