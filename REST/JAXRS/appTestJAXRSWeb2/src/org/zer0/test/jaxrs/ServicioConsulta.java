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

import org.zer0.test.jaxrs.security.SAASecurity;

@ApplicationPath("rest")
@Path("consulta")
public class ServicioConsulta extends Application implements SAASecurity {

	@GET
	@Path("getArray")
	@Produces("application/json")
	public List<String> getSampleData(@Context HttpHeaders headers,@QueryParam("value") String value) {
		return Arrays.asList(new String[] { "one", "two", "three", "four", value });
	}

	@GET
	@Path("getString")
	@Produces("application/json")
	public String getString() {
		return "Test";
	}

	@Override
	@GET
	@Path("getArray2")
	@Produces("application/json")
	public String getInformation() {
		return "Test";
	}

}
