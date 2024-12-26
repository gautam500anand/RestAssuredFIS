import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;


public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI= "https://api.coindesk.com";
		
		String response = given().log().all().header("Content-Type","application/json").when().get("v1/bpi/currentprice.json").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		
		Assert.assertEquals(js.getInt("bpi.size()"), 3);
		Assert.assertEquals(js.getString("bpi.GBP.description"), "British Pound Sterling");
		
	}

	}


