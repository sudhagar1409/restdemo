package test;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod extends Base {

	Response response;

	/*
	 * 5 step process: 1.Requirement 2.End Point with Resources 3.Create Request
	 * 4.Send Request 5.Validate Request
	 */
	@Test(priority = 1)
	public void postTestIncident() {
		


		response = request.body("{\"description\":\"I am testing it\"}").post("incident");

		sys_id = response.jsonPath().get("result.sys_id");
		response.then().assertThat().statusCode(201);
		System.out.println(sys_id);

	}

}
