package demovalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
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
		response = request.get("incident/" + "115edae593233110ff7c74418bba10c3");
		/*
		 * response.then().assertThat().statusCode(200); response.then().log().all();
		 */

		String rb = response.getBody().asString();
		/*
		 * System.out.println(rb);
		 */

		String rbone = response.asString();

		System.out.println(rbone);

		int code = response.getStatusCode();
		String st = response.getStatusLine();

		System.out.println(code);
		System.out.println(st);

		Assert.assertEquals(code, 200, "Mismatch of code");

		String ct = response.getHeader("Content-Encoding");

		System.out.println(ct);

		Headers headers = response.getHeaders();

		for (Header header : headers) {

			System.out.println("Header Name: " + header.getName());
			System.out.println("Header Value: " + header.getValue());

		}
		
		JsonPath jsonPath = response.jsonPath();
		String s = jsonPath.get("result.upon_approval");
		     
		System.out.println(s);
		
		
		Root root =response.getBody().as(Root.class);
		
		root.getResult().getSysId();
		
		

	}

}
