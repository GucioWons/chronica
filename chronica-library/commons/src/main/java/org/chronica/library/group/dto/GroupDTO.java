package org.chronica.library.group.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.dto.EntityDTO;
import org.chronica.library.group.enumerated.Category;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO extends EntityDTO {
    private String name;
    private String description;
    private Category category;
    private Long ownerId;
    private boolean deprecated;

}
