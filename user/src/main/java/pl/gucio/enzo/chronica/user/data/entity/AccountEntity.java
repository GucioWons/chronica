package pl.gucio.enzo.chronica.user.data.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNTS")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Nonnull
    @Column(unique = true)
    private String username;

    @Nonnull
    @Column(unique = true)
    private String mail;

    @Nonnull
    @Column(unique = true)
    private Long phoneNumber;

    private Boolean isActive = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private PersonEntity person;
}
