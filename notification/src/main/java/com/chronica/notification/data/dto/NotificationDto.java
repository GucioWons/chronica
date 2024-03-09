package com.chronica.notification.data.dto;

import java.time.LocalDateTime;

public record NotificationDto(
                               Long id,
                              String title,
                              String content,
                              LocalDateTime createdAt,
                              LocalDateTime openAt,
                              Long receiverId,
                              Boolean deprecated){
}
