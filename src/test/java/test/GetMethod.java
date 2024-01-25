package test;

import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;

public class GetMethod extends Base {

	/*
	 * 5 step process: 1.Requirement 2.End Point with Resources 3.Create Request
	 * 4.Send Request 5.Validate Request
	 */
	@Test
	
	public void getTestIncident() {

		request = RestAssured.given();
		System.out.println(sys_id);
		response = request.get("incident/" +"faf9abe793d33110ff7c74418bba10aa");
		response.then().assertThat().statusCode(200);
		response.then().log().all();

	}

}
