package com.chronica.notification.data.entity;


import com.chronica.notification.data.constant.PriorityType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALERTS")
@RequiredArgsConstructor
@Setter
@Getter
public class Alert extends Notification {
private PriorityType priorityType = PriorityType.Default;
}
