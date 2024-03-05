package pl.gucio.enzo.chronica.user.data.entity;


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
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String mail;

    @Column(unique = true, nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String password;

    private Boolean isActive = false;
    private Boolean deprecated;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private PersonEntity person;
}
