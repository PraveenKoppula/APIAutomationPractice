package com.qa.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;




public class LocalGetPostPutPatchDelete {
	
	@Test
	public void get() {
		
		baseURI = "http://localhost:3000/";
		given().get("/users")
		.then().statusCode(200).log().all();	
	}
	
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "albert");
		request.put("lastName", "einstein");
		request.put("subjectId", "2");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	
	
	@Test
	public void put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "albert");
		request.put("lastName", "gilbert");
		request.put("subjectId", "2");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
		.when()
			.put("/users/5939")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test
	public void patch() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Albert");
		request.put("lastName", "Gilbert");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
		.when()
			.patch("/users/2bf3")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000/";
		when().delete("/users/5939").then().statusCode(200);
		
	}
	

}
