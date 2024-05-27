package com.qa.tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;




public class TestDELETE {
	
	@Test
	public void testingDelete() {
		
		baseURI = "https://reqres.in";
		
		when()
			.delete("/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
		
	}
	
}
