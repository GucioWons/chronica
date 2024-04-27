package org.chronica.group.api.group.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoGroupExceptionHandler implements ExceptionMapper<NoGroupException> {
    @Override
    public Response toResponse(NoGroupException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
