package org.chronica.group.api.group.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Group {
    private Long id;
    private String name;
    private String description;
    private Category category;
    private Long ownerId;
    private boolean deprecated;
}
