import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static  io.restassured.RestAssured.*;

//import static org.hamcrest.Matchers.*;
//import static org.hamcrest.equalTo;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.path.json.JsonPath.from;

import static io.restassured.response.Response.*;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;

public class RestAssuredTest extends BaseTest {

	/*
	@BeforeAll
    public static void setup(){
        baseURI = "https://reqres.in";
        basePath = "/api/";
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
    */

	@Test
	@Description("Prueba inicial")
    public void LoginRequestTest(){

                given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("login")
                .then()
               .statusCode(200)
               .body("token", notNullValue());

    }

	
	@Test
    public void getSingleUserTest(){
            given()
                .get("users/2")
                .then()
                .statusCode(200)
                .body("data.email", equalTo("janet.weaver@reqres.in"));

    }
	
	@Test
    public void deleteUserTest(){
        given()
                .delete("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }


	@Test
	@Description("patchUserTest")
    public void patchUserTest(){
        String nameUpdated = given()
                .when()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .patch("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath().getString("name");

        assertThat(nameUpdated, equalTo("morpheus"));

    }

	@Test
	@Description("putUserTest")
    public void putUserTest(){
        String jobUpdated = given()
                .when()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .put("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath().getString("job");

        assertThat(jobUpdated, equalTo("zion resident"));
    }

	
	
	@Test
	@Description("getUsersTest")
	public void getUsersTest () {
		
		String response = given().when().get("users?page=2")
		.then().extract().body().asString();
		
		
		int page =from(response).get("page");
		int totalpages =from(response).get("total_pages");
		
		int idFridtUser = from(response).get("data[0].id");
		
		
		System.out.println("pages "+page);
		System.out.println("total pages "+totalpages);
		System.out.println("idFridtUser "+idFridtUser);
		
		List<Map> idsMayor10 = from(response).get("data.findAll { user -> user.id > 10 }");
		
		
		List<Map> usuario = from(response).get("data.findAll { user -> user.id > 10 && user.last_name == 'Howell' }");
		
		String email = idsMayor10.get(0).get("email").toString();
		
		System.out.println("email mayor de 10 "+email);
		
		System.out.println("lasName Howell "+usuario.get(0).get("email").toString());
	}
	
	
	@Test
	@Description("getTotalUsers")
	public void getTotalUsers () {
		
		String response = given().when().get("users?page=2")
		.then().extract().body().asString();
		
		//List<Map> usuario = from(response).get("data");
		
		int tamanio = from(response).get("data.size");
		
		System.out.println("idTotal "+tamanio);
		
		
		assertThat(tamanio, equalTo(6));
		
	}
	
	
	/**
	 * Serializacion de Objeto sin parseo de String y demas cosas
	 * 
	 */
	
	
	@Test
	@Description("createUserTest")
	public void createUserTest() {
		RequestUser rUser = new RequestUser();
		rUser.setName("morpheus");
		rUser.setJob("leader");
		
		
		ResponseUser respuestaUser = given()
		.when()
		.body(rUser)
		.post("users")
		.then()
		.extract()
		.body()
		.as(ResponseUser.class);
		
		//Prueba de match
		
		System.out.println("respuestaUser fecha "+respuestaUser.getCreatedAt());
		
		//assertThat(respuestaUser.getJob(), equalTo("leader"));
		assertThat(respuestaUser.getJob(), equalTo("pepe"));
		
	}
	
	
	@Test
	@Description("registerUserTest")
	public void registerUserTest() {
		RequestregisterUser rUser = new RequestregisterUser();
		rUser.setEmail("eve.holt@reqres.in");
		rUser.setPassword("pistol");
		
		
		ResponseRegisterUser respuestaUser = given()
		.when()
		.body(rUser)
		.post("register")
		.then()
		.extract()
		.body()
		.as(ResponseRegisterUser.class);
		
		//Prueba de match
		
		System.out.println("Token "+respuestaUser.getToken());
		
		assertThat(respuestaUser.getToken(),  notNullValue());
		//assertThat(respuestaUser.getJob(), equalTo("pepe"));
		
	}
	
	
	/*
	@Test
    public void LoginRequestTest(){
        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .log()
                .all();
                //.body("token", notNullValue());

    }
    */

}

