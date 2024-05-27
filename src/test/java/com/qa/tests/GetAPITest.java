//package com.qa.tests;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.hc.core5.http.ParseException;
//import org.apache.http.client.ClientProtocolException;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.qa.base.TestBase;
//import com.qa.client.RestClient;
//
//public class GetAPITest extends TestBase{
//	
//	public GetAPITest() throws FileNotFoundException {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	TestBase testBase;
//	RestClient restClient;
//	String url;
//	
//	@BeforeMethod
//	public void setup() throws FileNotFoundException 
//	{
//		testBase= new TestBase();
//		String webURL = prop.getProperty("URL");
//		String apiURL = prop.getProperty("ServiceURL");
//		
//		url = webURL+apiURL;	
//	}
//	
//	@Test
//	public void testGetCall() throws ClientProtocolException, IOException
//	{
//		restClient = new RestClient();
//		restClient.get(url);
//	
//	}
//	
//}
