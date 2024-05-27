package com.qa.tests;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class SDETQA_CreatePayloads {
	
	@Test
	void testPostUsingHashmap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "reddy");
		data.put("location","fremont");
		data.put("phone", "6501112222");
		
		String courseArr[] = {"Cypress", "PlayWright"};
		data.put("courses", courseArr);
		
		System.out.println(data);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("reddy"))
			.body("location",equalTo("fremont"))
			.body("phone", equalTo("6501112222"))
			.log().all();
	}
	
	
	@Test
	void testPostUsingJson()
	{
		JSONObject data = new JSONObject();
		
		data.put("name", "sunitha");
		data.put("location","gadwal");
		data.put("phone", "6501113333");
		
		String courseArr[] = {"JavaScript", "PlayWright"};
		data.put("courses", courseArr);
		
		
		System.out.println(data);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("sunitha"))
			.body("location",equalTo("gadwal"))
			.body("phone", equalTo("6501113333"))
			.log().all();
	}
	
	
	@Test
	void testPostUsingPOJO()
	{

		SDETQA_POJOData data = new SDETQA_POJOData();
		data.setName("david");
		data.setLocation("14L");
		data.setPhone("4444444444");
		
		String coursesArr[]= {"SAP","AWS"};
		data.setCourses(coursesArr);
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("david"))
			.body("location",equalTo("14L"))
			.body("phone", equalTo("4444444444"))
			.log().all();
	}

	@Test
	void testPostUsingExternalJsonFile() throws FileNotFoundException
	{

		File f = new File("/Users/praveenkoppula/eclipse-workspace/RestAPIPractice/body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("sunitha"))
			.body("location",equalTo("gadwal"))
			.body("phone", equalTo("6501113333"))
			.log().all();
	}
	
	@Test
	void testDelete()
	{
	
		when()
			.delete("http://localhost:3000/students/0edb")
		.then()
			.log().all();
	}
	
}
