package com.chronica.user.data.entity;

import com.chronica.user.logic.util.ConfirmationLinkGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "LINKS")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    private LocalDateTime generatedAt = LocalDateTime.now();
    private Integer expirationTime = 30;
    private final String generatedCode = ConfirmationLinkGenerator.generate();
    private Boolean deprecated = false;
}
