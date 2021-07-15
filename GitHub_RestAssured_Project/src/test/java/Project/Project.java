package Project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.groovy.ast.Variable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

public class Project {
	
	  // Declare request specification
    RequestSpecification requestSpec;
    // Declare response specification
    ResponseSpecification responseSpec;
    
    String SSHkey=null;
    int SSHid=54824124;
    
    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                //.setContentType(ContentType.JSON)
        		.addHeader("accept","application/vnd.github.v3+json")
                //set authorization header
                //.addHeader("Authorization","token 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")
                // Set base URL
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();
 
       /* responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Check if response contains name property
                .expectBody("status", equalTo("alive"))
                // Build response specification
                .build();*/
    }
    

    
    @Test(priority=0)
    public void postTest() throws IOException
    {
    	//String reqBodyString=getJsonFileContentAsString();
    	
    	String reqBodyString="\n" + 
				"{\n" + 
				"    \"title\": \"TestAPIKey\",\n" + 
				"    \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDD1j8jYM86m9Qtmp1+WTWYH+3bQssgE39ve1uLIotgBb9ECf8+W/Dv6bGz47hmXGvoR5QVjhTG9iIEn4FA+seWCxbU/IH8ekdv65ssvqCGtKvbDGHQx4eZmRDlsvt+z23ewtw70cO5l23jBhYzlV1GnkSlJhfc/3KOhpiQu5bNAhA7CuUMnHwi31aWqPmAVusLbkmk7115DXH3kC2lRS/iXRyy4ZNv1YMtWSqcs6Cd0fxOla5CoL3X2uFV6zF/aPV99LCDuXQjQ8KGDsOHPaiQijemvHCMMIwJhopPZ8kfXtzmK8DtJA+hld9/7dgR4wLPDhN6WtA2taKACIdV4SFD\"\n" + 
				"}\n" + 
				"\n" + 
				"";
    	System.out.println(reqBodyString);
    	Response response= given().spec(requestSpec).body(reqBodyString).when().auth()
				.preemptive()
				.basic("token","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").post("/user/keys");
    	System.out.println(response.getBody().asPrettyString());
    	SSHid=response.then().extract().path("id");
    	assertEquals(response.getStatusCode(),201);
   
    	
    	
    }
    
    @Test(priority=1)
    public void getTest()
    {
    	Response response = given().spec(requestSpec).when().auth()
				.preemptive()
				.basic("token","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").get("/user/keys");
    	
    	Reporter.log(response.getBody().asPrettyString());
    	System.out.print(response.getBody().asPrettyString());
    	assertEquals(response.getStatusCode(),200);
    }
    
    @Test(priority=2)
    public void deleteTest()
    {
    	
    	//54819025
    	Response response = given().spec(requestSpec).when().auth()
				.preemptive()
				.basic("token","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").when().delete("/user/keys/"+SSHid);
    	Reporter.log(response.getBody().asPrettyString());
    	System.out.print(response.getBody().asPrettyString());
    	assertEquals(response.getStatusCode(),204);
    
    	
    }

}
