import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {
	

	
	@Test(dataProvider="getdata")
	public void testingGet(String id)
	{
		baseURI = "https://reqres.in/api/users/";
		
	
	Response response =given().when().get(baseURI+id);
	int getStatuString=response.getStatusCode();
	System.out.println(getStatuString);
	
	String email=given().when().get(baseURI+id).then().extract().path("data.email");
	//int getStatuString=response.getStatusCode();
	System.out.println(email);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] petid=new Object[][] {{"7"},{"9"}};
		return petid;
	}

}
