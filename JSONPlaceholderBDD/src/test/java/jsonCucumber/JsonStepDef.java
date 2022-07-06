package jsonCucumber;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonStepDef {
	//public static Response response;
	
	@When("^I request for a resource$")
	public void i_request_for_a_resource() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
     Response response = request.get("/posts/1");		
     ResponseBody body = response.getBody();
     //Response in raw format
     System.out.println("Response Body is: " + body.asString());
	}
	@Then("^I get the resource$")
	public void i_get_the_resource() {
		
	    
	     }
	@When("^I request for a list of resources$")
	public void i_request_for_a_list_of_resource() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
		 Response response = request.get("/posts");
		ResponseBody body = response.getBody();
	    //Response in raw format
	    System.out.println("Response Body is: " + body.prettyPrint());
	}
	@Then("^I get list of resources$")
	public void i_get_list_of_resources() {
		
	}
	@When("^I add a new resource with \\\"([^\\\"])\\\",\\\"([^\\\"])\\,\\\"([^\\\"])\\\" and \\\"([^\\\"])\\ $")
	public void I_add_a_new_resource_with_and(String uid,String userid,String utitle,String ubody) {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
		   Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\"}" ).post("/posts");
		   ResponseBody body = response.getBody();
		    //Response in raw format
		    System.out.println("Response Body is: " + body.asString());
	}
	
	/*@When("I add a new resource with {id},{userId},{title} and {body}")
	public void i_add_a_new_resource_with_and(String uid, String userid, String utitle, String ubody) {
	   RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
			RequestSpecification request = RestAssured.given();
			   Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\"}" ).post("/posts");
			   ResponseBody body = response.getBody();
			    //Response in raw format
			    System.out.println("Response Body is: " + body.asString());
	    throw new io.cucumber.java.PendingException();
	}*/
	@Then("^The reource is added$")
	public void the_reource_is_added() {
		
	}
	@When("^I update a resource$")
	public void i_update_a_resource(DataTable dt) {
		
    	List<String> list = dt.transpose().asList(String.class);
    	
       	  String uid = dt.cell(0,0);
          String userid = dt.cell(0,1);
          String utitle = dt.cell(0,2);
          String ubody = dt.cell(0,3);
		   RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		    RequestSpecification request = RestAssured.given();
		    Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\"}" ).put("/posts/1");
		    ResponseBody body = response.getBody();
	        System.out.println(body.asString());
	}
	@Then("^the resource is added$")
	public void the_resource_is_added() {
		
     
	}
	@When("^I update a resource partially$")
	public void i_update_a_resource_partially() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
    Response response = request.body("{\"userId\":10,\"id\":1,\"title\":\"Wings of fire\",\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}").patch("/posts/1");
    ResponseBody body = response.getBody();
    //Response in raw format
    System.out.println("Response Body is: " + body.prettyPrint());
	}
	@Then("^The resource details get updated$")
	public void the_resource_details_get_updated() {
		  
	}
	@When("^I delete a resource$")
	public void i_delete_a_resource() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/posts/1");
		ResponseBody body = response.getBody();
	    //Response in raw format
	    System.out.println("Response Body is: " + body.asString());
	}
	
	@Then("^The resource gets deleted$")
	public void the_resource_gets_deleted() {
		
		  
	}
	@When("^I want to fetch particular userId resource$")
	public void i_want_to_fetch_particular_userId_resource() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
    Response response = request.queryParam("userId", "1").get("/posts");
   
	}
	@Then("^I get that userId resources$")
	public void i_get_that_userId_resources() {
		 
	}
}
