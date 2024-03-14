package com.chronica.user.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PEOPLE")
@RequiredArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    @OneToOne(mappedBy = "person")
    private Account account;
}
