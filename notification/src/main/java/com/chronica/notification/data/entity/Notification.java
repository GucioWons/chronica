package com.chronica.notification.data.entity;

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
    protected Boolean seen = false;
    public Notification(){}
}
