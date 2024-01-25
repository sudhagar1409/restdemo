package test;

import org.testng.annotations.Test;

import base.Base;
import io.restassured.response.Response;

public class DeleteMethod extends Base {

	@Test(dependsOnMethods = { "test.PostMethod.postTestIncident" })
	public void deleteTestIncident() {

		response = request.delete("incident/" + sys_id);

		String statusLine = response.statusLine();

		System.out.println(statusLine);

		response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
		
		
		// Its always a better practise that after a delete then perform a get operation and make sure that deleted record is not available (404- resource not found)
		
		/*
		 * { "error": { "message": "No Record found", "detail":
		 * "Record doesn't exist or ACL restricts the record retrieval" }, "status":
		 * "failure"
		 */
		
		Response res = request.get("incident/" + sys_id);
		res.then().assertThat().statusCode(404);

	}

}
