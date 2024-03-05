package pl.gucio.enzo.chronica.user.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gucio.enzo.chronica.user.logic.util.ConfirmationLinkGenerator;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "LINKS")
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private Long id;
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private AccountEntity account;
    private LocalDateTime generatedAt = LocalDateTime.now();
    private Integer experienceTime = 30;
    private final String generatedCode = ConfirmationLinkGenerator.generate();
}
