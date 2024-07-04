package org.chronica.project.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.library.project.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;
import org.chronica.project.data.exception.NoProjectException;
import org.chronica.project.data.mapper.ProjectMapper;
import org.chronica.project.data.repository.ProjectRepository;

import java.util.List;


@RequiredArgsConstructor
@ApplicationScoped
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Transactional
    public ProjectDTO createProject(ProjectDTO toSave) {
        Project project = projectMapper.mapToNewEntity(toSave);
        project.persist();
        return projectMapper.mapToDTO(project);
    }

    public ProjectDTO getProjectById(Long projectId) {
        return projectRepository
                .findByIdNotDeprecated(projectId)
                .map(projectMapper::mapToDTO)
                .orElseThrow(() -> new NoProjectException("Cannot find Project with id " + projectId));
    }

    public List<ProjectDTO> getProjectsByGroupId(Long groupId) {
        return projectRepository
                .findByGroupId(groupId)
                .stream()
                .map(projectMapper::mapToDTO)
                .toList();
    }

    public List<ProjectDTO> getProjects() {
        return projectRepository
                .listAllNotDeprecated()
                .stream()
                .map(projectMapper::mapToDTO)
                .toList();
    }

    @Transactional
    public ProjectDTO updateProject(Long projectId, ProjectDTO dto) {
        Project project = projectMapper.mapToUpdateEntity(projectRepository
                .findByIdNotDeprecated(projectId)
                .orElseThrow(() -> new NoProjectException("Cant update, project not exist")), dto);
        project.persist();
        return projectMapper.mapToDTO(project);
    }

    @Transactional
    public String deprecateProject(Long projectId) {
        Project project = projectRepository
                .findByIdNotDeprecated(projectId)
                .orElseThrow(() -> new NoProjectException("Cannot find Project with id " + projectId));
        project.setDeprecated(true);
        project.persist();
        return "Project has been deprecated.";
    }


}

