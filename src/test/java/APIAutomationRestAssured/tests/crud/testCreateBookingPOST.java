package APIAutomationRestAssured.tests.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import APIAutomationRestAssured.base.BaseTest;
import APIAutomationRestAssured.endpoints.APIConstants;
import APIAutomationRestAssured.modules.PayloadManager;
import APIAutomationRestAssured.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;

public class testCreateBookingPOST extends BaseTest {
	
	PayloadManager payloadManager;
	
	@Test
	@Owner("Kashyap")
	@Severity(SeverityLevel.NORMAL)
	@Description("TC#1 - Verify that the booking can be created")
	public void testCreateBooking()
	{	
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = RestAssured.given().spec(requestSpecification)
				.body(payloadManager.createPayloadBookingAsString())
				.when().post();
		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
		
		
		BookingResponse bookingResponse = payloadManager.bookingresponseJava(response.asString());
		System.out.println("BookIng response is :::::::: "+bookingResponse);
		
		
		//------------------------------------------------------------
//		System.out.println("base path ----- :"+APIConstants.CREATE_UPDATE_BOOKING_URL);
//		
//		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
//		response = RestAssured.given(requestSpecification).body(payloadManager.createPayloadBookingAsString()).when()
//				.post();
//
//		validatableResponse = response.then().log().all();
//
//		validatableResponse.statusCode(200);
////		validatableResponse.body("booking.firstname", Matchers.equalTo("Siddhi"));
//		
//		//De-serialize the response
//		
//		BookingResponse bookingResponse = payloadManager.bookingresponseJava(response.getBody().asString());
//		System.out.println("BookIng response is :::::::: "+bookingResponse);
		
		
		
		//AsertJ
		assertThat(bookingResponse.getBookingId()).isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isNotBlank().isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Siddhi");
		
		//TestNg assertions
		assertActions.verifyStatusCode(response, 200);
		
	}
	
	
	
	
	@Test
	@Owner("Kashyap")
	@Severity(SeverityLevel.NORMAL)
	@Description("TC#2 - Verify that the booking can be created with invalid - Empty payload")
	public void testCreateBookingNegative()
	{
		System.out.println("base path ----- :"+APIConstants.CREATE_UPDATE_BOOKING_URL);
		
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = RestAssured.given(requestSpecification).body(payloadManager.createPayloadBookingAsString())
				.when().post();
		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(500); 
		
		
		
//		TestNg assertions
//				assertActions.verifyStatusCodeInvalidReq(500);
		
		
	}
	
	
	
	
	
	
	
	
	

}
