package org.chronica.project.data.mapper;



import org.chronica.project.data.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;

import javax.enterprise.context.ApplicationScoped;

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
        return new Project(
                dto.getName(),
                dto.getGroupId(),
                dto.getCreatedDate(),
                dto.getLastChangeDate(),
                dto.isDeprecated()
        );
    }
}
