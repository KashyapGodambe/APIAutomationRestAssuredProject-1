package APIAutomationRestAssured.tests.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import APIAutomationRestAssured.base.BaseTest;
import APIAutomationRestAssured.endpoints.APIConstants;
import APIAutomationRestAssured.pojos.Booking;
import APIAutomationRestAssured.pojos.BookingResponse;
import APIAutomationRestAssured.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;

public class TCIntegration extends BaseTest{
	
//	Create booking, generate a token
//	Get booking
//	Update a booking
//	Delete a booking


	
	
	
	@Test(groups="integration", priority = 1)
	@Owner("Kashyap")
	@Description("TC#1 - Step 1 - Verify that the booking can be created")
	public void testCreateBooking(ITestContext iTestContext)
	{
		iTestContext.setAttribute("token", getToken());
		
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = RestAssured.given().spec(requestSpecification)
				.body(payloadManager.createPayloadBookingAsString())
				.when().post();
		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
		
		
		BookingResponse bookingResponse = payloadManager.bookingresponseJava(response.asString());
		
		
		
		
		//AsertJ
		assertThat(bookingResponse.getBookingId()).isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isNotBlank().isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Siddhi");
		
		
		//Set the Booking id
		iTestContext.setAttribute("bookingid", bookingResponse.getBookingId());
		
		System.out.println("Booking id From CREATE BOOKING test : --> "+ iTestContext.getAttribute("bookingid"));
		
			
		
		
	}
	
	
	@Test(groups="integration", priority = 2)
	@Owner("Kashyap")
	@Description("TC#2 - Step 2 - Verify that booking is created using booking id")
	public void testVerifyBookingId(ITestContext iTestContext)
	{	
		
		System.out.println("The Booking Id is : " +iTestContext.getAttribute("bookingid"));
		
		System.out.println("The token is : " +iTestContext.getAttribute("token"));
		
		Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
		//restbooker/booking/123
		//GET Request 
		
		String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId;
		System.out.println("GET req URL is : "+basePathGet);
		
		requestSpecification.basePath(basePathGet);
		response = RestAssured.given().spec(requestSpecification)
				.when().get();		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
		
		String jsonResponse = response.getBody().asString();
		System.out.println("Response Body is : " + jsonResponse);
		
		Booking booking  = payloadManager.getResponseFromJSON(jsonResponse);
		
		//verification
		assertThat(booking.getFirstname().trim()).isNotBlank().isNotNull();
		assertThat(booking.getFirstname().trim()).isEqualTo("Siddhi");
		//assertThat(booking.getLastname().trim()).isEqualTo(PropertyReader.readKey("booking.lastname"));
		
		
		//Assert.assertEquals(firstNameJsonPathExtracted, "Sujawalla");
		

	}
	
	
	@Test(groups="integration", priority = 3)
	@Owner("Kashyap")
	@Description("TC#3 - Step 3 - Verify the updated booking by id")
	public void testUpdateByBookingId(ITestContext iTestContext)
	{
		
		System.out.println("The token is : " +iTestContext.getAttribute("token"));
		
		String token = (String) iTestContext.getAttribute("token");
		
		Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
		//PUT //PATCH

		String basePathputPatch = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId;
		System.out.println("GET req URL is : "+basePathputPatch);
		
		requestSpecification.basePath(basePathputPatch);
		response = RestAssured.given().spec(requestSpecification).cookie("token", token)
				.when().body(payloadManager.fullUpdatePayloadAsString()).put();		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
		
		Booking booking  = payloadManager.getResponseFromJSON(response.getBody().asString());
		
		//verification
		assertThat(booking.getFirstname()).isNotBlank().isNotNull();
		assertThat(booking.getFirstname()).isEqualTo("Riddhi");
		assertThat(booking.getLastname()).isEqualTo("Chatre");
		
		
		
	}
	
	@Test(groups="integration", priority = 4)
	@Owner("Kashyap")
	@Description("TC#4 - Step 4 - Delete the booking by id")
	public void testDeleteByBookingId(ITestContext iTestContext)
	{
		
		Assert.assertTrue(true);
		String token = (String) iTestContext.getAttribute("token");

		System.out.println("The token is : " +iTestContext.getAttribute("token"));
		
		Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
		
		String basePathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId;
		System.out.println("GET req URL is : "+basePathDelete);
		
		requestSpecification.basePath(basePathDelete).cookie("token", token);
		validatableResponse = RestAssured.given().spec(requestSpecification)
				.when().delete().then().log().all();
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
		
		
		
	}
	

}
