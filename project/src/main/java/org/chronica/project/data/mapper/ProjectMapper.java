package org.chronica.project.data.mapper;


import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.project.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;

import java.time.LocalDateTime;

@ApplicationScoped
public class ProjectMapper implements BaseMapper<Project, ProjectDTO> {
    @Override
    public ProjectDTO mapToDTO(Project entity) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGroupId(entity.getGroupId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastChangeDate(entity.getLastChangeDate());
        dto.setDeprecated(entity.isDeprecated());
        return dto;
    }

    @Override
    public Project mapToNewEntity(ProjectDTO dto) {
        return new Project(
                dto.getName(),
                dto.getGroupId(),
                dto.getCreatedDate(),
                dto.getLastChangeDate(),
                dto.isDeprecated()
        );
    }

    @Override
    public Project mapToUpdateEntity(Project toUpdate, ProjectDTO dto) {
        if (dto.getName() != null) {
            toUpdate.setName(toUpdate.getName());
        }
        if (dto.getGroupId() != null) {
            toUpdate.setGroupId(toUpdate.getGroupId());
        }
        if (dto.getLastChangeDate() != null) {
            toUpdate.setLastChangeDate(LocalDateTime.now());
        }
        return toUpdate;
    }
}
