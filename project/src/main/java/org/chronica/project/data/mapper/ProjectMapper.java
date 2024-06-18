package org.chronica.project.data.mapper;



import jakarta.enterprise.context.ApplicationScoped;
import org.chronica.project.data.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;

import java.time.LocalDate;
import java.time.LocalDateTime;


@ApplicationScoped
public class ProjectMapper {
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

    public Project mapToEntity(ProjectDTO dto) {
       Project entity = new Project();
       entity.setName(dto.getName());
       entity.setGroupId(dto.getGroupId());
       entity.setCreatedDate(LocalDate.from(LocalDateTime.now()));
       return entity;
    }
}
