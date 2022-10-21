import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.requestSpecification;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;






public abstract class BaseTest {

	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeAll
    public static void setup(){
		
		logger.info("Iniciando ....");
		
        //baseURI = "https://reqres.in";
        //basePath = "/api/";
		
		baseURI = ConfVariables.getHost();
        basePath = ConfVariables.getPath();
        
        System.out.println("baseURI "+ConfVariables.getHost());
        System.out.println("basePath "+basePath);
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        
        //filters(new AllureRestAssured());
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
	
	
}
