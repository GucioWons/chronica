package com.chronica.project.data.mapper;

import com.chronica.project.data.entity.Project;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.project.dto.ProjectDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
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
        Project project = new Project();
        project.setName(dto.getName());
        project.setGroupId(dto.getGroupId());
        project.setCreatedDate(dto.getCreatedDate());
        project.setLastChangeDate(dto.getLastChangeDate());
        project.setDeprecated(dto.isDeprecated());
        return project;
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
