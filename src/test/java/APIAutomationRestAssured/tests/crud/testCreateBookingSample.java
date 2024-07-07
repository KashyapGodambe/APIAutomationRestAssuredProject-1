package APIAutomationRestAssured.tests.crud;

import org.testng.annotations.Test;

import APIAutomationRestAssured.base.BaseTest;
import APIAutomationRestAssured.endpoints.APIConstants;
import APIAutomationRestAssured.modules.PayloadManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;





@Test(groups="smoke")
@Owner("Kashyap")
@Severity(SeverityLevel.NORMAL)

public class testCreateBookingSample extends BaseTest{
	//structure for create booking
	PayloadManager payloadManager;
	
	public void testCreateBooking()
	{
		System.out.println("base path ----- :"+APIConstants.CREATE_UPDATE_BOOKING_URL);
		
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = RestAssured.given(requestSpecification).body(payloadManager.createPayloadBookingAsString())
				.when().post();
		
		
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200); 
	}
	

}
