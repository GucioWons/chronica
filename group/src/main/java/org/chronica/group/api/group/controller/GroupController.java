package org.chronica.group.api.group.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.chronica.group.api.group.entity.Group;
import org.chronica.group.api.group.logic.GroupService;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Group> createGroup(Group group) {
        return RestResponse.ResponseBuilder
                .ok(groupService.createGroup(group), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Group> getGroupById(@PathParam("groupId") Long groupId) {
        return RestResponse.ResponseBuilder
                .ok(groupService.getGroupById(groupId), MediaType.APPLICATION_JSON)
                .build();
    }
}
