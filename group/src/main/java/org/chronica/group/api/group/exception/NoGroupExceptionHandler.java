package org.chronica.group.api.group.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoGroupExceptionHandler implements ExceptionMapper<NoGroupException> {
    @Override
    public Response toResponse(NoGroupException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
