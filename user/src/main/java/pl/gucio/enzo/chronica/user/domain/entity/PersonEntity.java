package pl.gucio.enzo.chronica.user.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "PEOPLE")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String name;
    private String lastName;
    private Integer age;

    @OneToOne(mappedBy = "person")
    private AccountEntity account;
}
