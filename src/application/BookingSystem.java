package application;

public class BookingSystem {
	
	
	public void calculateTotalPrice(double basePrice) {
		
	}
	
	public void bookMovieTicket(Customer custName, Theater theater, Schedule date, Seat seatNumber) throws Exception{
		if(!theater.seatBooked(date,  seatNumber)) {
			theater.bookSeat(date, seatNumber);
		}
		
		else {
			throw new Exception("Seat is booked");
		}
	}
}
