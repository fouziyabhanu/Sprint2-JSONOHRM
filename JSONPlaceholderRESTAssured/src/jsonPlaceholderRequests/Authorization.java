package jsonPlaceholderRequests;

import org.testng.Assert;
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
            
            .basic("postman", "password")
            
            .header("Content-Type", "application/json")
            
            .header("Authorization"," Basic cG9zdG1hbjpwYXNzd29yZA==");
    
    Response response = request.get();
    
    System.out.println(response.asString());
    
    int statusCode = response.getStatusCode();
    
    //Status code
    
    Assert.assertEquals(statusCode , 200 , "Successful");
    System.out.println("Status code=> " + response.getStatusCode());
    
    //Status line
    
    String statusLine = response.getStatusLine();
    Assert.assertEquals(statusLine , "HTTP/1.1 200 OK" , "Correct status code returned");
    System.out.println("Status line => " + response.getStatusLine());
}
}
