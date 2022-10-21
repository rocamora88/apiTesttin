package es.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NewTest {
	@Test
	public void testGetUsers() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		//String stCode = RestAssured.given().when().get("/users").then().statusCode(200).extract().body().asString();
		String body = RestAssured.given().when().get("/users").then().extract().body().asString();
		
		//System.out.println("STAUS CODE "+stCode);
		System.out.println("BODY "+body);
	}
}
