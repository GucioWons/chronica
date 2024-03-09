package com.chronica.notification.data.entity;


import com.chronica.notification.data.constant.NotificationType;
import com.chronica.notification.data.constant.PriorityType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALERTS")
@RequiredArgsConstructor
@Setter
@Getter
public class Alert extends NotificationAbstractEntity {
private PriorityType priorityType;
}
