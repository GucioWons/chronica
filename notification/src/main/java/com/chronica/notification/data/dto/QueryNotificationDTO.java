package com.chronica.notification.data.dto;

import java.util.List;

public record QueryNotificationDTO(List<NotificationDTO> notifications, NotificationDTO filter, PagingAndSortingDTO pageSettings){
}
