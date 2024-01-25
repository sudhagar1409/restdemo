package test;

import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;

public class GetTest extends Base {

	/*
	 * 5 step process: 1.Requirement 2.End Point with Resources 3.Create Request
	 * 4.Send Request 5.Validate Request
	 */
	@Test(dependsOnMethods = { "test.PostMethod.postTestIncident" }) 
	
	public void getTestIncident() {

		request = RestAssured.given();
		response = request.get("incident/" +sys_id);
		response.then().assertThat().statusCode(200);
		response.then().log().all();

	}

}
