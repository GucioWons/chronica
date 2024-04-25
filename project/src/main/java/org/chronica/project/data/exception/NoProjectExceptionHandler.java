package org.chronica.project.data.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoProjectExceptionHandler implements ExceptionMapper<NoProjectException> {
    @Override
    public Response toResponse(NoProjectException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
