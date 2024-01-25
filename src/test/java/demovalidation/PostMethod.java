package demovalidation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestbody.RequestBody;

public class PostMethod extends Base {

	Response response;

	/*
	 * 5 step process: 1.Requirement 2.End Point with Resources 3.Create Request
	 * 4.Send Request 5.Validate Request
	 */
	@Test(priority = 1)
	public void postTestIncident() throws JsonProcessingException {
		
		/*
		 * JSONObject jo = new JSONObject(); jo.put("description", "I am testing it");
		 */
		
		RequestBody rb = new RequestBody();
		rb.setDescription("I am testing it");
		
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(rb);
		
		
	
		

		response = request.body(writeValueAsString).post("incident"); 
		

		sys_id = response.jsonPath().get("result.sys_id");
		response.then().assertThat().statusCode(201);
		System.out.println(sys_id);

	}

}
