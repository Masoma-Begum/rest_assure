package rest_assure.com;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;

public class TokenValidation {
	String authToken = "";

	
	@BeforeTest
	public void setToken() {
		//Register member
		JSONObject jo = new JSONObject();
		jo.put("email", "john@mail.com");
		jo.put("name", "Jhon");
		jo.put("password", "54321");
		jo.put("role", "admin");
		jo.put("avatar", "http://test.api/com");
		given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
			.body(jo.toString())
			.when()
			.post("https://api.escuelajs.co/api/v1/users")
			.then()
			.assertThat()
			.statusCode(201)
			.log().all();
		    
		// Generate Token
		authToken = given()
				
		.contentType(ContentType.JSON)
		.body(jo.toString())
		.when()
		.post("https://api.escuelajs.co/api/v1/auth/login")
		.jsonPath()
		.getString("access_token");
	}
	 //Get user using Header (Authorization)
	@Test
	public void withToken() {
		Map<String, String> apiheaders = new HashMap<String, String>(){
			{
				//put("Accept", "*/*");
				put("Authorization", "Bearer " + authToken);
			}
		};
		
		
			given()
			.headers(apiheaders)
			.when()
			.get("https://api.escuelajs.co/api/v1/auth/profile")
			.then()
			.assertThat()
			.statusCode(HttpStatus.SC_OK);		
		
	
	}
	//Try to get user not using Header (Authorization) it will show an exception that is unauthorized
	@Test
	public void withoutToken() {
		Map<String, String> apiheaders = new HashMap<String, String>(){
			{
				put("Accept", "*/*");
			}
		};
			given()
			.headers(apiheaders)
			.when()
			.get("https://api.escuelajs.co/api/v1/auth/profile")
			.then()
			.assertThat()
			.statusCode(HttpStatus.SC_UNAUTHORIZED);		
		
	
	}

	

}
