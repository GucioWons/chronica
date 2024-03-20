package com.chronica.notification.data.entity;

import com.chronica.notification.data.constant.NotificationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DynamicUpdate
@AllArgsConstructor
@Setter
@Getter
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String title;
    protected String content;
    protected LocalDateTime createdAt;
    protected LocalDateTime viewAt;
    protected Long receiverId;
    protected Boolean deprecated = false;
    protected NotificationType notificationType;
    protected Boolean seen = false;

    public Notification(NotificationType notificationType, Long id, String title, String content, LocalDateTime createdAt, LocalDateTime viewAt, Long receiverId, Boolean deprecated, Boolean seen) {
        this.notificationType = notificationType;
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.viewAt = viewAt;
        this.receiverId = receiverId;
        this.deprecated = deprecated;
        this.seen = seen;
    }
    public Notification(){}

    public void setNotification(Notification notification) {
        if(notification.getTitle() != null) {
            this.title = notification.getTitle();
        }
        if(notification.getContent() != null) {
            this.content = notification.getContent();
        }
        if(notification.getCreatedAt() != null) {
            this.createdAt = notification.getCreatedAt();
        }
        if(notification.getViewAt() != null) {
            this.viewAt = notification.getViewAt();
        }
        if(notification.getReceiverId() != null) {
            this.receiverId = notification.getReceiverId();
        }
        if(notification.getNotificationType() != null) {
            this.notificationType = notification.getNotificationType();
        }
        if(notification.getSeen() != null) {
        this.seen = notification.getSeen();
        }
    }

    public Notification getNotification(){
        return this;
    }
}
