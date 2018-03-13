package org.zer0.test.jaxrs;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.zer0.test.jaxrs.interceptor.SAASecurity;

@ApplicationPath("rest")
@Path("consulta")
public class ServicioConsulta extends Application {

	@GET
	public Response echo(@Context HttpHeaders headers,@QueryParam("message") String message) {
		return Response.ok().entity(message == null ? "no message" : message).build();
	}
	
	@GET
    @Path("jwt")
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }

	@GET
	@Path("getArray")
	@Produces("application/json")
	@SAASecurity
	public List<String> getSampleData(@Context HttpHeaders headers,@QueryParam("value") String value) {
		return Arrays.asList(new String[] { "one", "two", "three", "four", value });
	}

	@GET
	@Path("getString")
	@Produces("application/json")
	public String getString() {
		return "Test";
	}

}
