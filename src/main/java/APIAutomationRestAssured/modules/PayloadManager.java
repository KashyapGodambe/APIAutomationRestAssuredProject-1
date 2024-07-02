package APIAutomationRestAssured.modules;

import com.google.gson.Gson;

import APIAutomationRestAssured.pojos.Booking;
import APIAutomationRestAssured.pojos.BookingDates;
import APIAutomationRestAssured.pojos.BookingResponse;

//import ex_270624.gson.serialization.Booking;
//import ex_270624.gson.serialization.BookingDates;

public class PayloadManager {
	
	
	Gson gson;
	
	public String createPayloadBookingAsString()
	{
		
		
		
		Booking booking = new Booking();
		booking.setFirstname("Siddhi");
		booking.setLastname("Mhatre");
		booking.setTotalprice(420);
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2023-06-23");
		bookingdates.setCheckout("2024-06-26");
		
		booking.setBookingdates(bookingdates);
		booking.setAdditionalneeds("Breakfast");
		
		return gson.toJson(booking);
	}
	
	
	
	public String fullUpdatePayloadAsString()
	{
		
		
		
		Booking booking = new Booking();
		booking.setFirstname("Riddhi");
		booking.setLastname("Chatre");
		booking.setTotalprice(444);
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2023-06-23");
		bookingdates.setCheckout("2024-06-26");
		
		booking.setBookingdates(bookingdates);
		booking.setAdditionalneeds("Breakfast");
		
		return gson.toJson(booking);
	}
	
	
	
	public BookingResponse bookingresponseJava(String responseString)
	{
		//Deserialize
		gson = new Gson();
		
		BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
		return bookingResponse;
	}
	

}
