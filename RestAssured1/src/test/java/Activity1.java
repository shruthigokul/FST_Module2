

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.testng.annotations.Test;
 
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Activity1 {
	
	@Test
	public void POSTReqestTestCase() throws IOException
	{
		baseURI = "https://petstore.swagger.io/v2/pet";
		
		//Creating an InputStream object
	      InputStream inputStream = new FileInputStream("C:\\Users\\ShruthiGokul\\eclipse-workspace\\RestAssured1\\src\\main\\resources\\inp.json");
	      //creating an InputStreamReader object
	      InputStreamReader isReader = new InputStreamReader(inputStream);
	      //Creating a BufferedReader object
	      BufferedReader reader = new BufferedReader(isReader);
	      StringBuffer sb = new StringBuffer();
	      String str;
	      while((str = reader.readLine())!= null){
	         sb.append(str);
	      }
	      System.out.println(sb.toString());
		/* // Import JSON file
	    FileInputStream inputJSON = new FileInputStream(new File("C:\\Users\\ShruthiGokul\\eclipse-workspace\\RestAssured1\\src\\main\\resources\\inp.json"));
	    // Read JSON file as String
	    String reqBody = inputJSON.toString();
	    System.out.println(reqBody);*/
		
		Response response =given().contentType(ContentType.JSON).body(sb.toString()).when().post(baseURI);
		int getStatuString=response.getStatusCode();
		System.out.println(getStatuString);
	}

}
