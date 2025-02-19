package com.chronica.user.api.link.entity;

import com.chronica.user.api.link.logic.helper.ConfirmationLinkGenerator;
import com.chronica.user.api.account.entity.Account;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.chronica.library.commons.model.ChronicaEntity;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Link implements ChronicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    private LocalDateTime generatedAt = LocalDateTime.now();
    private Integer expirationTime = 30;
    private final String generatedCode = ConfirmationLinkGenerator.generate();
    private Boolean deprecated = false;
}
