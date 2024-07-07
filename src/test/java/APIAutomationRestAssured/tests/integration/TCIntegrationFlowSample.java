package APIAutomationRestAssured.tests.integration;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIAutomationRestAssured.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

public class TCIntegrationFlowSample extends BaseTest {
	
	
//	Create booking, generate a token
//	Get booking
//	Update a booking
//	Delete a booking


	
	
	
	@Test(groups="integration", priority = 1)
	@Owner("Kashyap")
	@Description("TC#1 - Step 1 - Verify that the booking can be created")
	public void testCreateBooking()
	{
		Assert.assertTrue(true);
		
		
	}
	
	
	@Test(groups="integration", priority = 2)
	@Owner("Kashyap")
	@Description("TC#2 - Step 2 - Verify that booking is created by booking id")
	public void testVerifyBookingId()
	{
		Assert.assertTrue(true);
		
	}
	
	
	@Test(groups="integration", priority = 3)
	@Owner("Kashyap")
	@Description("TC#3 - Step 3 - Verify the updated booking by id")
	public void testUpdateByBookingId()
	{
		Assert.assertTrue(true);
		
		
	}
	
	@Test(groups="integration", priority = 4)
	@Owner("Kashyap")
	@Description("TC#4 - Step 4 - Delete the booking by id")
	public void testDeleteByBookingId()
	{
		
		Assert.assertTrue(true);
		
	}
	

}
