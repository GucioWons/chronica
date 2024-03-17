package org.chronica.group.api.group.dto;

import org.chronica.group.api.group.entity.Category;

public record GroupDTO(
        Long id,
        String name,
        String description,
        Category category,
        Long ownerId,
        boolean deprecated) {

}
