package jsonPlaceholderNegative;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	@Test
	public void basicAuth() {
	RestAssured.baseURI ="https://postman-echo.com/basic-auth";
	
    RequestSpecification request = RestAssured.given()
    		
            .auth()
            
            .basic("postman", "password123")
            
            .header("Content-Type", "application/json")
            
            .header("Authorization"," Basic cG9zdG1hbjpwYXNzd29yZA==");
    
    Response response = request.get();
    
    System.out.println(response.asString());
}
}