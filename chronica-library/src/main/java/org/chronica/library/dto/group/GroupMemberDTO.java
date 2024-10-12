package org.chronica.library.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;
import org.chronica.library.enumerated.GroupCategory;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupMemberDTO extends EntityDTO {
    private Long userMemberId;
    private Set<GroupDTO> groups;
}
