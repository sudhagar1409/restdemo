package test;

import org.testng.annotations.Test;

import base.Base;

public class PatchMethod extends Base {

	@Test(dependsOnMethods = { "test.PostMethod.postTestIncident" })

	public void updateTestIncident() {

		response = request.body("{\"description\":\"I am testing it and updating the full contents\"}").put("incident/" + sys_id);

		response.then().assertThat().statusCode(200);

	}

}
