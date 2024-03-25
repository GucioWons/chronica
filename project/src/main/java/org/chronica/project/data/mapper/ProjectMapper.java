package org.chronica.project.data.mapper;


import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.project.data.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;

import java.time.LocalDateTime;

@ApplicationScoped
public class ProjectMapper {
    public ProjectDTO mappToDTO(Project entity) {
        return new ProjectDTO(
                entity.id,
                entity.getName(),
                entity.getGroupId(),
                entity.getCreatedDate(),
                entity.getLastChangesDate(),
                entity.isDeprecated()
        );
    }

    public Project mappToEntity(ProjectDTO dto) {
        return new Project(
                dto.name(),
                dto.groupId(),
                dto.createdDate(),
                dto.lastChangesDate(),
                dto.isDeprecated()
        );
    }

    public Project mappToUpdateEntity(Project entity, ProjectDTO dto) {
        if (dto.name() != null) {
            entity.setName(dto.name());
        }
        if (dto.groupId() != null) {
            entity.setGroupId(dto.groupId());
        }
        if (dto.lastChangesDate() != null) {
            entity.setLastChangesDate(LocalDateTime.now());
        }
        return entity;
    }
}
