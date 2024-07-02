package APIAutomationRestAssured.tests.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import APIAutomationRestAssured.base.BaseTest;
import APIAutomationRestAssured.endpoints.APIConstants;
import APIAutomationRestAssured.modules.PayloadManager;
import APIAutomationRestAssured.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class testCreateBookingPOST extends BaseTest {
	
	PayloadManager payloadManager;
	
	@Test
	@Owner("Kashyap")
	@Severity(SeverityLevel.NORMAL)
	@Description("TC#1 - Verify that the booking can be created")
	public void testCreateBooking()
	{
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = requestSpecification.given().body(payloadManager.createPayloadBookingAsString())
				.when().post();
		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
		
		//De-serialize the response
		
		BookingResponse bookingResponse = payloadManager.bookingresponseJava(response.asString());
		
		
		
		
		//AsertJ
		assertThat(bookingResponse.getBookingId()).isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isNotBlank().isNotNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Siddhi");
		
		//TestNg assertions
		assertActions.verifyStatusCode(response);
		
	}
	
	
	

}
