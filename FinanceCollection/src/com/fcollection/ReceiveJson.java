package com.fcollection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/ReceiveJson")
public class ReceiveJson {
	static private String name2;
	
	@GET
	// @Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "<body><h1>" + "Hello World RESTful Jersey"
				+ "</body></h1>" + "</html> ";
	}


	@GET
	@Path("/hey")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello1() {
		return "hhhiii";
	}


	//
	@GET
	@Path("/{id : .+}")
	public String getOrder(@PathParam("id") String id) {

		return id;

	}

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String consumeJSON(String student) throws JSONException {

		JSONObject js = new JSONObject(student);
		String name1 = (String) js.get("name");
		String age = (String) js.get("age");
		name2 = name1;

		return name1 + age;

	}
	
	@GET
	@Path("/disp")
	@Produces(MediaType.APPLICATION_JSON)
	public String dispJson(){
		return name2;
	}

	@POST
	@Path("/insertcust")
	@Consumes(MediaType.APPLICATION_JSON)
	public String consumeJSON1(String student) throws JSONException {

		JSONObject js = new JSONObject(student);
		String name1 = (String) js.get("name");
		String output = student.toString();

		// System.out.println(output);
		return name1;
		// return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/jj/{id}")
	// @Produces(MediaType.APPLICATION_JSON)
	public String profilepullmethod(@PathParam("id") String id) {
		System.out.println(id);
		return "hhii" + id;
	}

}
