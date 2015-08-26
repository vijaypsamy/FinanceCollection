package com.fcollection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javassist.expr.NewArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;


@Path("/OMJson")
public class OMJson {

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomers() {

		String str = "{ \"customers\" : [";
		int live, accno;
		try {
			
			Connection con = DBConnection.getConnection();
		
			String query = "select account_number, flag from dlqtable";
			System.out.println("after con");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("before str1");

			String str1 = "{ \"employees\": [{\"lastName\": \"Doe\", \"firstName\": \"John\"}, {\"lastName\": \"Smith\", \"firstName\": \"Anna\"},  {\"lastName\": \"Jones\",\"firstName\": \"Peter\"}]}";
		
			ResultSet rs = st.executeQuery(query);
			System.out.println("Before while loop");
			while(rs.next()){
				
				System.out.println("inside while loop");
				accno = rs.getInt("account_number");
				live = rs.getInt("flag");
				if(rs.isLast()){
					str = str+"{\"accno\":\""+accno+"\", \"live\":\""+live+"\"}]}";
				}
				else {
					
					str = str+"{\"accno\":\""+accno+"\", \"live\":\""+live+"\"},";
				}
				System.out.println("Accno: "+accno);
				
			}
			
	
					
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;

	}
}