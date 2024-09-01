package com.chronica.project.controller;


import com.chronica.project.logic.ProjectService;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.project.ProjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(ProjectDTO toSave) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(projectService.createProject(toSave));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getProjects() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.getProjects());
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<ProjectDTO>> getProjectsByGroupId(@PathVariable("groupId") Long groupId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.getProjectsByGroupId(groupId));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("projectId") Long projectId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.getProjectById(projectId));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("projectId") Long projectId, ProjectDTO toUpdate) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.updateProject(projectId, toUpdate));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable("projectId") Long projectId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.deprecateProject(projectId));
    }
}
