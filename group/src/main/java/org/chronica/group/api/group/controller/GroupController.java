package org.chronica.group.api.group.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.chronica.group.api.group.dto.GroupDTO;
import org.chronica.group.api.group.logic.GroupService;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GroupDTO> createGroup(GroupDTO toSave) {
        return RestResponse.ResponseBuilder
                .ok(groupService.createGroup(toSave), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<List<GroupDTO>> getGroups() {
        return RestResponse.ResponseBuilder
                .ok(groupService.getGroups(), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GroupDTO> getGroupById(@PathParam("groupId") Long groupId) {
        return RestResponse.ResponseBuilder
                .ok(groupService.getGroupById(groupId), MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<GroupDTO> updateGroup(@PathParam("groupId") Long groupId, GroupDTO toUpdate) {
        return RestResponse.ResponseBuilder
                .ok(groupService.updateGroup(groupId, toUpdate), MediaType.APPLICATION_JSON)
                .build();
    }

    @DELETE
    @Path("/{groupId}")
    @Produces(MediaType.TEXT_PLAIN)
    public RestResponse<String> deleteGroup(@PathParam("groupId") Long groupId) {
        return RestResponse.ResponseBuilder
                .ok(groupService.deprecateGroup(groupId), MediaType.TEXT_PLAIN)
                .build();
    }
}
