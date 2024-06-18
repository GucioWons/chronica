package org.chronica.project.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.chronica.project.data.dto.ProjectDTO;
import org.chronica.project.logic.ProjectService;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<ProjectDTO> createProject(ProjectDTO toSave) {
        return RestResponse.ResponseBuilder
                .ok(projectService.createProject(toSave), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<List<ProjectDTO>> getProjects() {
        return RestResponse.ResponseBuilder
                .ok(projectService.getProjects(), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/group/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<List<ProjectDTO>> getProjectsByGroupId(Long groupId) {
        return RestResponse.ResponseBuilder
                .ok(projectService.getProjectsByGroupId(groupId), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<ProjectDTO> getProjectById(@PathParam("projectId") Long projectId) {
        return RestResponse.ResponseBuilder
                .ok(projectService.getProjectById(projectId), MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{projectId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<ProjectDTO> updateProject(@PathParam("projectId") Long projectId, ProjectDTO toUpdate) {
        return RestResponse.ResponseBuilder
                .ok(projectService.updateProject(projectId, toUpdate), MediaType.APPLICATION_JSON)
                .build();
    }

    @DELETE
    @Path("/{projectId}")
    @Produces(MediaType.TEXT_PLAIN)
    public RestResponse<String> deleteProject(@PathParam("projectId") Long projectId) {
        return RestResponse.ResponseBuilder
                .ok(projectService.deprecateProject(projectId), MediaType.TEXT_PLAIN)
                .build();
    }
}
