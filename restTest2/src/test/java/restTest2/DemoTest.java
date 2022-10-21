package restTest2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class DemoTest {

	
	
	//@Test
	public void testGetUsers() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		//String stCode = RestAssured.given().when().get("/users").then().statusCode(200).extract().body().asString();
		//String body = RestAssured.given().when().get("/users").then().extract().body().asString();
		
		//System.out.println("STAUS CODE "+stCode);
		//System.out.println("BODY "+body);
		
		//String stCode = RestAssured.given().when().get("/users").then().extract().body().asString();
		 given().when().get("/users").then().statusCode(200)
				.body("data[0].first_name", equalTo("George"));
	}
	
	//@Test
	public void testPostUsers() {
		baseURI = "https://reqres.in/api";
		
		//String stCode = RestAssured.given().when().get("/users").then().extract().body().asString();
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("name","luisa");
		map.put("job", "profesor");
		given()
		.log().all()
		.body(map.toString())
		.when().post("/users").then()
		.log().all()
		.statusCode(201);
	}
	
	
	@Test
	public void testDeleteUsers() {
		baseURI = "https://reqres.in/api";
		
		//String stCode = RestAssured.given().when().get("/users").then().extract().body().asString();
		//Map<String,Object> map= new HashMap<String,Object>();
		//map.put("name","luisa");
		//map.put("job", "profesor");
		given()
		.log().all()
		//.body(map.toString())
		.when().delete("/users/711").then()
		.log().all()
		.statusCode(204);
	}
	

}
