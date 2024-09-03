package org.chronica.library.dto.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.dto.EntityDTO;
import org.chronica.library.enumerated.GroupCategory;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO extends EntityDTO {
    private String name;
    private String description;
    private GroupCategory category;
    private Long ownerId;
}
