package APIAutomationRestAssured.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import APIAutomationRestAssured.pojos.Auth;
import APIAutomationRestAssured.pojos.Booking;
import APIAutomationRestAssured.pojos.BookingDates;
import APIAutomationRestAssured.pojos.BookingResponse;
import APIAutomationRestAssured.pojos.TokenResponse;

//import ex_270624.gson.serialization.Booking;
//import ex_270624.gson.serialization.BookingDates;

public class PayloadManager {
	
	
	 Gson gson;
	
	
	public String createPayloadBookingAsString()
	{
		
		System.out.println("Executing Method createPayloadBookingAsString");
		
		Booking booking = new Booking();
		Faker faker = new Faker();
		
		booking.setFirstname("Siddhi");
		//booking.setLastname(faker.name().lastName());
		booking.setLastname("Godbole");
		booking.setTotalprice(faker.random().nextInt(1000));
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2023-06-23");
		bookingdates.setCheckout("2024-06-26");
		
		booking.setBookingdates(bookingdates);
		booking.setAdditionalneeds("Breakfast");
		
		
		gson = new Gson();
		String jsonPayload = gson.toJson(booking);
		System.out.println("Payload for Create Booking : " +jsonPayload);
		return jsonPayload;
	}
	
	
	public String createInvalidPayloadBookingAsString() {
        return "{}";
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
	
	
	
	public String SetAuthPayload()
	{
		Auth auth = new Auth();
		auth.setUsername("admin");
		auth.setPassword("password123");
		
		gson =  new Gson();
		//serialization > converting JSON obj to JSON string
		String jsonPayloadString = gson.toJson(auth);
		System.out.println("Payload set to : " +jsonPayloadString);
		return jsonPayloadString;
	}
	
	
	public String getTokenFromJSON(String tokenResponse)
	{
		gson =  new Gson();
		//Deseralization 
		//response >> JSON --> Object --tokenReponse
		
		TokenResponse tokenReponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
		
		return tokenReponse1.getToken();		
		
	}
	
	
	public Booking getResponseFromJSON(String getResponse)
	{
		gson =  new Gson();
		//Deseralization 
		//response >> JSON --> Object --tokenReponse
		
		Booking booking = gson.fromJson(getResponse, Booking.class);
		
		return booking;	
		
	}
	

}
