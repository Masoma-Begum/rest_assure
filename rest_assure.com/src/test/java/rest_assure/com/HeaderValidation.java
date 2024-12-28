package rest_assure.com;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class HeaderValidation {
	
	@Test (priority = 1)
   public void responseHeaderValidation() {
	RestAssured.baseURI="https://api.escuelajs.co/api/v1/auth/";
	given()
	.when()
	.get("/profile")
	.then()
	.header("Server", "Cowboy")
	.and()
	.header("X-Powered-By", "Express");
	
	// get all headers
	//.log().headers();
	
}
	@Test (priority = 2)
	public void getHeader() {
	 Response response =  given()
	  .when()
	.get("/profile");
	 
	 // Get single value
	String value = response.getHeader("Etag");
	 System.out.println("Response Header Etag: " + value);
	
	 // get all headers
	 Headers allHeaders = response.getHeaders();
	 for(Header hr : allHeaders) {
		 System.out.println(hr.getName()+":    "+hr.getValue());
	 }
	 
	
		
	}
}
