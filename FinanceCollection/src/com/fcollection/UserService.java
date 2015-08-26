package com.fcollection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() {

		String str = "{ \"employees\": [{\"lastName\": \"Doe\", \"firstName\": \"John\"}, {\"lastName\": \"Smith\", \"firstName\": \"Anna\"}, {\"lastName\": \"Jones\",\"firstName\": \"Peter\"}]}";
		return str;

	}
}