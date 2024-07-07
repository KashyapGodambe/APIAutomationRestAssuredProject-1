package APIAutomationRestAssured.base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import APIAutomationRestAssured.actions.AssertActions;
import APIAutomationRestAssured.endpoints.APIConstants;
import APIAutomationRestAssured.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	// BaseTest - Father >>> TestCase - Son > Single inheritance

	public RequestSpecification requestSpecification;
	public Response response;
	public ValidatableResponse validatableResponse;
	public AssertActions assertActions;
	public PayloadManager payloadManager;
	public JsonPath jsonPath;

	@BeforeTest
	public void setUp() {
		System.out.println("----Before test---- ");

		payloadManager = new PayloadManager();
		assertActions = new AssertActions();
		requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL)
				.addHeader("Content-Type", "application/json").build().log().all();

		// -------OR--------

//		requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).contentType(ContentType.JSON).log()
//				.all();

	}

	public String getToken() 
	{	
		
		//Setting up the URL
		requestSpecification = RestAssured.given()
				.baseUri(APIConstants.BASE_URL)
				.basePath(APIConstants.Auth_URL);
		
		//Setting up the payload
		String payload = payloadManager.SetAuthPayload();
		
		
		//getting the response
		response = requestSpecification.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post();
		
		//extracting of token via desealization
		String token = payloadManager.getTokenFromJSON(response.asString());
		
		
		
		return token;
		
		
	}
	
	
	
	
	

}
