package application;

public class Seat {

	private char row;
	private int column;
	
	private Boolean bookingStatus = false;
	
	public Seat(char row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Boolean bookingStatus(Schedule date) {
		return this.bookingStatus;
		
	}
	
	public void bookSeat() {
		this.bookingStatus = true;
	}
}
