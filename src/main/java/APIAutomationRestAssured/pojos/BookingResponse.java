package APIAutomationRestAssured.pojos;

public class BookingResponse {
	
	private Integer bookingid;
	private Booking booking;
	
	
	public Integer getBookingId() {
		return bookingid;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingid = bookingId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	

}
