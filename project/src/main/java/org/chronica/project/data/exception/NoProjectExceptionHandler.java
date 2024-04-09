package org.chronica.project.data.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoProjectExceptionHandler implements ExceptionMapper<NoProjectException> {
    @Override
    public Response toResponse(NoProjectException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
