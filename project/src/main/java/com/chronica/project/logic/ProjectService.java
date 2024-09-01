package com.chronica.project.logic;

import com.chronica.project.data.entity.Project;
import com.chronica.project.data.exception.NoProjectException;
import com.chronica.project.data.mapper.ProjectMapper;
import com.chronica.project.data.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.project.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectDTO createProject(ProjectDTO toSave) {
        return projectMapper.mapToDTO(projectRepository.save(projectMapper.mapToNewEntity(toSave)));
    }

    public ProjectDTO getProjectById(Long projectId) {
        return projectRepository
                .findByIdAndDeprecatedFalse(projectId)
                .map(projectMapper::mapToDTO)
                .orElseThrow(() -> new NoProjectException("Cannot find Project with id " + projectId));
    }

    public List<ProjectDTO> getProjectsByGroupId(Long groupId) {
        return projectRepository
                .findByGroupIdAndDeprecatedFalse(groupId)
                .stream()
                .map(projectMapper::mapToDTO)
                .toList();
    }

    public List<ProjectDTO> getProjects() {
        return projectRepository
                .findAllByDeprecatedFalse()
                .stream()
                .map(projectMapper::mapToDTO)
                .toList();
    }

    @Transactional
    public ProjectDTO updateProject(Long projectId, ProjectDTO dto) {
        Project project = projectMapper.mapToUpdateEntity(projectRepository
                .findByIdAndDeprecatedFalse(projectId)
                .orElseThrow(() -> new NoProjectException("Cant update, project not exist")), dto);
        return projectMapper.mapToDTO(projectRepository.save(project));
    }

    @Transactional
    public String deprecateProject(Long projectId) {
        Project project = projectRepository
                .findByIdAndDeprecatedFalse(projectId)
                .orElseThrow(() -> new NoProjectException("Cannot find Project with id " + projectId));
        project.setDeprecated(true);
        projectRepository.save(project);
        return "Project has been deprecated.";
    }


}

