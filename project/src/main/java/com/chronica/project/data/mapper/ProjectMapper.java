package com.chronica.project.data.mapper;

import com.chronica.project.data.entity.Project;
import org.chronica.library.commons.mapper.BaseMapper;
import org.chronica.library.project.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "jakarta")
public class ProjectMapper implements BaseMapper<Project, ProjectDTO> {
    ProjectDTO mapToDTO(Project entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    Project mapToNewEntity(ProjectDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deprecated", ignore = true)
    Project mapToUpdateEntity(@MappingTarget Project toUpdate, ProjectDTO dto);
}
