import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.payload;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//validate if add place api is working or not
		//Add place-> Update place with new address->get the place to validate if new address is present in response
		
		//Given = all input details
		//when = submit the API-resource,http method
		//Then = Validate the response
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.headers("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);//for parsing Json
		
		String placeID=js.getString("place_id");
		System.out.println(placeID);
		
		

		
		
		
	}

}
