package jsonPlaceholderNegative;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FilteringResources {
	@Test
	public void filteringResource() {
		
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.queryParam("userId", "50").get("/posts");
		
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		
		//Response in raw format
		System.out.println("Response Body is: " + body.prettyPrint());
}
}