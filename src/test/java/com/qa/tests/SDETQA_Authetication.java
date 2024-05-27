package com.qa.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SDETQA_Authetication {

	@Test
	void basicAuth()
	{
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
		System.out.println("Testing API");
	}

	@Test
	void digestAuth()
	{
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
	}
	
	
	@Test
	void preemptiveAuth()
	{
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
	}

	
	// Bearer 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
	
	@Test
	void bearerTokenAuth()
	{
		String bearerToken = "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";

		given()
			.header("Authorization","Bearer "+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().headers();
		
	}
	
	
}
