package base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	static public RequestSpecification request = null;
	static public Response response = null;
	static public String sys_id = null;

	@BeforeMethod

	public void setUp() throws IOException {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/";

		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		properties.load(fis);
		String user = properties.getProperty("username");
		String password = properties.getProperty("password");
		RestAssured.authentication = RestAssured.basic(user, password);
		request = RestAssured.given().contentType(ContentType.JSON);

	}
	
	/*
	 * @AfterMethod public void tearDown() { System.out.println("Status Code : "
	 * +response.statusCode()); }
	 */

}
