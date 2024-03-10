package org.chronica.group.api.group.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.chronica.group.api.group.entity.Group;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/groups")
public class GroupController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Group> getGroupById() {
        return RestResponse.ResponseBuilder
                .ok(new Group(), MediaType.APPLICATION_JSON)
                .build();
    }
}
