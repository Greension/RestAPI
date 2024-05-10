package stepDefinitions;
import static io.restassured.RestAssured.given;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class stepDefinition {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	@Given("Add Place Payload")
	public void add_place_payload() {
		RestAssured.baseURI="https://rahulshettyacademy.com";

		AddPlace p =new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);

		 RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		 
		 
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res=given().spec(req)
		.body(p);
	}
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		res.when().post("/maps/api/place/add/json").
				then().spec(resspec).extract().response();
	}
	@Then("The API call got Success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    int str = response.getStatusCode();
	    System.out.println(str);
		assertEquals(response.getStatusCode(),200);
	}
	


	
	}





