package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class SDETQA_PathQueryParameters {

	// @Test
	void testQueryPathParameters() {

		given().pathParam("mypath", "users").queryParam("page", 2).queryParam("id", 8).when()
				.get("https://reqres.in/api/{mypath}").then().statusCode(200).log().all();
	}

	@Test
	void testHeaders() {

//		given()
//		.when()
//			.get("https://reqres.in/api/users")
//		.then()
//			.log().cookies();
//			.log().body();
//			.log().headers();
//			.log().all();

		Response res = when().get("https://reqres.in/api/users");

		if (res.headers() != null)
			System.out.println("SUCCESS");
		if (res.cookies() != null)
			System.out.println("SUCCESS");
		else
			System.out.println("FAIL");

		// products[4].category.category

		Response resp = when().get("https://automationexercise.com/api/productsList");

		String category = resp.jsonPath().get("products[4].category.category").toString();

		System.out.println(category);
		Assert.assertEquals(category, "Tops");

	}

	@Test
	void validateResponse() {
		Response resp = given()
							.contentType(ContentType.JSON)
						.when()
							.get("https://automationexercise.com/api/productsList");
		
		String category = resp.jsonPath().get("products[4].category.category").toString();
		
		System.out.println(category);
		Assert.assertEquals(category, "Tops");
		System.out.println();
		
		JSONObject jo = new JSONObject(resp.asString());
		
		for(int i=0; i< jo.getJSONArray("products").length();i++)
		{
			String productName = jo.getJSONArray("products").getJSONObject(i).get("name").toString();
			System.out.println(productName);
		}
		

	}

}
