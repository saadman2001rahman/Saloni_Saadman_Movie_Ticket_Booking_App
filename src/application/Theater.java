package application;

public class Theater {
	
	private Seat[] allSeats;
	private String theaterName;
	
	public Theater(Seat[] allSeats, String theaterName) {
		this.theaterName = theaterName;
		this.allSeats = allSeats;
		
	}
	
	public Boolean seatBooked(Schedule date, Seat seat) {
		return seat.bookingStatus(date);
	}
	
	public void bookSeat(Schedule date, Seat seatNumber) {
		
	}
	
	public String getTheatreName() {
		return theaterName;
	}

}
