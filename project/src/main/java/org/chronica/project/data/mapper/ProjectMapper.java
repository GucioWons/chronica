package org.chronica.project.data.mapper;


import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.project.data.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;

import java.time.LocalDateTime;

@ApplicationScoped
public class ProjectMapper {
    public ProjectDTO mapToDTO(Project entity) {
        return new ProjectDTO(
                entity.id,
                entity.getName(),
                entity.getGroupId(),
                entity.getCreatedDate(),
                entity.getLastChangeDate(),
                entity.isDeprecated()
        );
    }

    public Project mapToEntity(ProjectDTO dto) {
        return new Project(
                dto.name(),
                dto.groupId(),
                dto.createdDate(),
                dto.lastChangeDate(),
                dto.isDeprecated()
        );
    }
}
