package creatingResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreatingStepDef {
	@When("^I add a new resource with \"([^\"])\" ,\"([^\"])\",\"([^\"])\",and \"([^\"])\" $")
	public void I_add_a_new_resource_with_and(String uid,String userid,String utitle,String ubody) {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
		   Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\"}" ).post("/posts");
		   ResponseBody body = response.getBody();
		    //Response in raw format
		    System.out.println("Response Body is: " + body.asString());
	}
	@Then("^The reource is added$")
	public void the_reource_is_added() {
		
	}
}
