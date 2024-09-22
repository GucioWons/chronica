package org.chronica.library.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.dto.EntityDTO;
import org.chronica.library.enumerated.GroupCategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO extends EntityDTO {
    private String name;
    private String description;
    private GroupCategory category;
    private Long ownerId;
}
