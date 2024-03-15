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
    protected Boolean seen = false;

    public Notification(NotificationType notificationType, Long id, String title, String content, LocalDateTime createdAt, LocalDateTime openAt, Long receiverId, Boolean deprecated, Boolean seen) {
        this.notificationType = notificationType;
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.openAt = openAt;
        this.receiverId = receiverId;
        this.deprecated = deprecated;
        this.seen = seen;
    }
    public Notification(){}
}
