package com.fcollection;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONObject {

	public static void main(String[] args) {

		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5,"
				+ "  \"owners\" : [\"John\", \"Jack\", \"Jill\"],"
				+ "  \"nestedObject\" : { \"field\" : \"value\" } }";

		try {

			ObjectMapper objectMapper = new ObjectMapper();

			URL url = new URL(
					"http://www.json-generator.com/api/json/get/ckyFNsEiaa?indent=2");

			JsonNode jnode = objectMapper.readValue(url, JsonNode.class);
			JsonNode employees = jnode.get("employees");
			JsonNode emp1 = employees.get(0);
			JsonNode firstName = emp1.get("firstName");
			String name1 = firstName.asText();
	
			System.out.println("name"+name1);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}