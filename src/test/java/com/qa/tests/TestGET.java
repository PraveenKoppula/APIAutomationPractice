package com.qa.tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestGET {

	@Test
	public void test1() {
		
		Response resp=get("https://reqres.in/api/users?page=2");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		
		System.out.println(resp.getBody().asString());
		
	}
	
	
	@Test
	public void test2() {
		
		baseURI = "https://reqres.in/api";
		given()
			.get("/users?page=2")
		.then()
			.statusCode(200)
			.body("data[1].id",equalTo(8))
			.log().all();
		
	}
	
}
