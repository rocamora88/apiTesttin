package restTest2;

//import io.restassured.RestAssured;
//import org.testng.annotations.Test;

public class Demo2 {

	public static void main(String[] args) {
		Demo2 de = new Demo2();
		//de.testGetUsers();
	}
/*	
	@Test
	public void testGetUsers() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		String stCode = RestAssured.given().when().get("/users").then().statusCode(200).extract().body().asString();
		//String body = RestAssured.given().when().get("/users").then().extract().body().asString();
		
		System.out.println("STAUS CODE "+stCode);
		//System.out.println("BODY "+body);
	}
*/
}
