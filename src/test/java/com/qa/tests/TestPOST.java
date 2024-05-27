package com.qa.tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;




public class TestPOST {
	
	
	@Test
	public void testingPost() {
		
		baseURI = "https://reqres.in/api";

		JSONObject request = new JSONObject();
		
		request.put("name", "Praveen");
		request.put("job", "SSDET");
		
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
}
