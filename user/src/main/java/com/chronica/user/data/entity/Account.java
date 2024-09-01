package com.chronica.user.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.chronica.library.commons.model.ChronicaEntity;
import org.chronica.library.enumerated.UserRole;

import java.time.LocalDateTime;
import java.util.List;

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
    private boolean active = true; //For testing switch to true
    private boolean deprecated = false;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "account_roles", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private List<UserRole> userRoles;
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

}
