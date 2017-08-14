package server.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//@Provider
public class DoNotFoundExceptionMapper implements ExceptionMapper<DoNotFoundException> {

	@Override
	public Response toResponse(DoNotFoundException e) {
			
		ErrorMessage msg = new ErrorMessage(e.getMessage(), e.getErrorCode());
		return Response.status(Status.NOT_FOUND).entity(msg).build();
	}
	

}
