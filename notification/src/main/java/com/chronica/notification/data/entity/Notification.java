package com.chronica.notification.data.entity;

import com.chronica.notification.data.constant.NotificationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DynamicUpdate
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String title;
    protected String content;
    protected LocalDateTime createdAt;
    protected LocalDateTime openAt;
    protected Long receiverId;
    protected Boolean deprecated = false;
    protected NotificationType notificationType;

    public Notification(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime openAt, Long receiverId, Boolean deprecated) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.openAt = openAt;
        this.receiverId = receiverId;
        this.deprecated = deprecated;
    }
    public Notification(){}
}
