package com.chronica.user.data.entity;

import com.chronica.user.data.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNTS")
@RequiredArgsConstructor
@Setter
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String mail;
    @Column(unique = true, nullable = false)
    private Long phoneNumber;
    @Column(nullable = false)
    private String password;
    private Boolean isActive = true; //For testing switch to true
    private Boolean deprecated = false;
    private Role role = Role.USER;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
