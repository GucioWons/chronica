package org.chronica.project.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.project.data.dto.ProjectDTO;
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
        Project project = projectMapper.mappToEntity(toSave);
        project.persist();
        return projectMapper.mappToDTO(project);
    }

    public ProjectDTO getProjectById(Long projectId) {
        return projectRepository
                .findByIdNotDeprecated(projectId)
                .map(projectMapper::mappToDTO)
                .orElseThrow(() -> new NoProjectException("Cannot find Project with id " + projectId));
    }

    public List<ProjectDTO> getProjects() {
        return projectRepository
                .listAllNotDeprecated()
                .stream()
                .map(projectMapper::mappToDTO)
                .toList();
    }

    @Transactional
    public ProjectDTO updateProject(Long projectId, ProjectDTO toUpdate) {
        Project project = projectRepository
                .findByIdNotDeprecated(projectId)
                .map(entity -> projectMapper.mappToUpdateEntity(entity,toUpdate))
                .orElseThrow(() -> new NoProjectException("Cannot find Project with id " + projectId));
        project.persist();
        return projectMapper.mappToDTO(project);
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

