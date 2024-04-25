package org.chronica.project.logic;


import lombok.RequiredArgsConstructor;
import org.chronica.project.data.dto.ProjectDTO;
import org.chronica.project.data.entity.Project;
import org.chronica.project.data.exception.NoProjectException;
import org.chronica.project.data.mapper.ProjectMapper;
import org.chronica.project.data.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@ApplicationScoped
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Transactional
    public ProjectDTO createProject(ProjectDTO toSave) {
        Project project = projectMapper.mapToEntity(toSave);
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
    public ProjectDTO updateProject(Long projectId, ProjectDTO toUpdate) {
        Project project = projectRepository
                .findByIdNotDeprecated(projectId).orElseThrow(() -> new NoProjectException("Cant update, project not exist"));

        if (toUpdate.getName() != null) {
            project.setName(toUpdate.getName());
        }
        if (toUpdate.getGroupId() != null) {
            project.setGroupId(toUpdate.getGroupId());
        }
        if (toUpdate.getLastChangeDate() != null) {
            project.setLastChangeDate(LocalDateTime.now());
        }

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

