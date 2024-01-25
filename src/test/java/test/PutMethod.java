package test;

import org.testng.annotations.Test;

import base.Base;

public class PutMethod extends Base {

	@Test(dependsOnMethods = { "test.PostMethod.postTestIncident" })
	public void putTestIncident() {

		response = request.body("{\"description\":\"I am testing it and updating the partial contents\"}")
				.put("incident/" + sys_id);
		response.then().assertThat().statusCode(200);
	}

}
