package APIAutomationRestAssured.pojos;

public class Booking {
	
//	String Payload = "{\r\n"
//			+ "    \"firstname\" : \"Manav\",\r\n"
//			+ "    \"lastname\" : \"Mane\",\r\n"
//			+ "    \"totalprice\" : 520,\r\n"
//			+ "    \"depositpaid\" : false,\r\n"
//			+ "    \"bookingdates\" : {\r\n"
//			+ "        \"checkin\" : \"2023-01-01\",\r\n"
//			+ "        \"checkout\" : \"2024-02-01\"\r\n"
//			+ "    },\r\n"
//			+ "    \"additionalneeds\" : \"Breakfast, Lunch, Dinner\"\r\n"
//			+ "}";
	
	
	
	private String firstname;
	private String lastname;
	private Integer totalprice;
	private Boolean depositpaid;
	private BookingDates bookingdates;
	private String additionalneeds;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public Boolean getDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(Boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public BookingDates getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	@Override
	public String toString() {
		return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
				+ additionalneeds + "]";
	}
	
	
	
	
	
	
	
	

}
