package com.qa.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class SDETQA_HTTPRequests {
	
	int id;
	
	@Test(priority=1)
	void getUsers()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();	
	}

	@Test(priority=2)
	void createUser()
	{
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("name", "janet");
		data.put("job","tester");
		
		id= given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
		
		System.out.println(id);
		
	}
	
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("name", "koppu");
		data.put("job","qalead");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
		
		System.out.println(id);
		
	}

	
	@Test(priority=4)
	void daleteUser()
	{		
		when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
		
	
}
