package rest_assure.com;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.CycleDetectingLockFactory.WithExplicitOrdering;
import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetUserInfo {
/*	JSONObject jo = new JSONObject();
	//@BeforeTest
	public void setToken() {
		//Register member
		
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
	}
	

	public void login() {
		Response response = (Response) given()
		// Response response = RestAssured.given()
				.contentType(ContentType.JSON)
			    .accept(ContentType.JSON)
				.body(jo.toString())
		            .when()
		            .get("https://api.escuelajs.co/api/v1/users")
		            .then()
		            .log().all();
		
		        
		        // Print or use the value
		       // System.out.println("Extracted Value: " + value);
		
	}*/

//	import io.restassured.RestAssured;
//	import io.restassured.response.Response;
//	import io.restassured.path.json.JsonPath;
//	import org.testng.annotations.Test;
//
//	import java.util.List;

//https://www.youtube.com/watch?v=SBp5rStA3vQ&list=PLUDwpEzHYYLvLZX_QEGTNolPvNADXid0I&index=7
 String mail;
	 String pass;
@Test
public void testGetEmailById() {
             
     JsonPath response = (JsonPath) given()
    		 .when()
 			.get("https://reqres.in/api/users?page=2")
 			  .then()
 			  .log().body()
              .statusCode(200)
              .extract()
              .response(); 
     
    
  List< Map<String, Object>> namelist = response.getList("");
  
  for (Map<String, Object>users: namelist) {
	  
	  if(users.get("id").equals(1)) {
		  System.out.println(users.get("email"));
		  break;
	  }
	
	
}
//   System.out.println(namelist);
            
	
	
	
	/*List<Object> userList = jsonPath.getList("");
	mail = null;
	pass = null;
	for(Object user: userList) {
		JsonPath userjson = new JsonPath(user.toString());
		Integer userid = userjson.getInt("id");
		if(userid != null && userid == 1) {
			mail = userjson.getString("email");
			pass = userjson.getString("password");
			break;
		}

	}
	System.out.println("Email: " + mail);*/
                	
	       /*------------------------------------
	        *  // Send a GET request and extract JsonPath directly
        JsonPath jsonPath = given()
            .when()
                .get("/endpoint-to-get-data")
            .then()
                .statusCode(200)  // Ensure the status code is 200 OK
                .extract()
                .jsonPath();  // Extract JsonPath directly

        // Use JsonPath to extract data
        // Adjust the path based on the actual structure of your JSON response
        int id = jsonPath.getInt("id"); // Example path; update as needed
        String name = jsonPath.getString("name"); // Example path; update as needed

	        * --------------------------------------------------------------------
	        */
                	
                	/*  @Test
					public void getEmailById() {
                	        // Set the base URI for the API
                	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

                	        // Send GET request to retrieve the list of users
                	        Response response = RestAssured.given()
                	                                       .when()
                	                                       .get("/users");

                	        // Check if the request was successful
                	        Assert.assertEquals(response.getStatusCode(), 200, "Request failed");

                	        // Extract the list of users from the JSON response
                	        JsonPath jsonPath = response.jsonPath();
                	        List<Object> users = jsonPath.getList("");
                	         List<Object> users = jsonPath.getList("$");

                	        String email = null;

                	        // Iterate through the list of users to find the user with ID = 1
                	        for (Object user : users) {
                	            JsonPath userJson = new JsonPath(user.toString());
                	            Integer id = userJson.getInt("id");
                	            if (id != null && id == 1) {
                	                // Extract email of the user with ID = 1
                	                email = userJson.getString("email");
                	                break;
                	            }
                	        }

                	        // Print the email
                	        System.out.println("Email: " + email);*/
         //--------------------------------------------*/

}}
