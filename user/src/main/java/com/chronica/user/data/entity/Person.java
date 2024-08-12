package com.chronica.user.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.chronica.library.model.ChronicaEntity;

@Entity
@RequiredArgsConstructor
@Data
public class Person implements ChronicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @OneToOne(mappedBy = "person")
    private Account account;

}
