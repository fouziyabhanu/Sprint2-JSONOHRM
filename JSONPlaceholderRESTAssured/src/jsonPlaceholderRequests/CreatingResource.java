package jsonPlaceholderRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreatingResource {
	@Test
	public void creatingResource() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		
		RequestSpecification request = RestAssured.given();
		
     Response response = request.body("{\"userId\": 1,\"id\": 2,\"title\": \"qui est esse\",\"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla}").post("/posts");
    
     // Retrieve the body of the Response
   
     ResponseBody body = response.getBody();
    
     //Response in raw format
    System.out.println("Response Body is: " + body.asString());

  //Assert that correct status code is returned.
    int statusCode = response.getStatusCode();
    
    Assert.assertEquals(statusCode , 201 , "Successful");
    
    System.out.println("Status code => " + response.getStatusCode());
    
    String statusLine = response.getStatusLine();
    
    Assert.assertEquals(statusLine , "HTTP/1.1 201 Created" , "Correct status code returned");
    
    System.out.println("Status line => " + response.getStatusLine());
    
  //Access header with a given name.
    
    String contentType = response.header("Content-Type");
    
    System.out.println("Content-Type value: " + contentType);
    
    Assert.assertEquals(contentType, contentType);
    
  //Access header with a given name. Header = Content-Encoding
    
    String acceptLanguage = response.header("Content-Encoding");
    
    System.out.println("Content-Encoding: " + acceptLanguage);
    
}
}
