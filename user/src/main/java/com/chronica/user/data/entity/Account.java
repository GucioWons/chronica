package com.chronica.user.data.entity;

import org.chronica.library.user.enumerated.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.chronica.library.model.ChronicaEntity;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
public class Account implements ChronicaEntity {

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
    private boolean active = false; //For testing switch to true
    private boolean deprecated = false;
    private Role role = Role.USER;
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

}
