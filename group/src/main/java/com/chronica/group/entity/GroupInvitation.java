package com.chronica.group.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.enumerated.InvitationStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "my_group_invitations")
public class GroupInvitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long invitedUserId;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    private InvitationStatus invitationStatus;
    private boolean deprecated = false;
}
