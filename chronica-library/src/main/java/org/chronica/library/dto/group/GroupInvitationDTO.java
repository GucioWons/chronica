package org.chronica.library.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;
import org.chronica.library.enumerated.InvitationStatus;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupInvitationDTO extends EntityDTO {
    private Long invitedUserId;
    private InvitationStatus invitationStatus;
    private GroupDTO group;
}
