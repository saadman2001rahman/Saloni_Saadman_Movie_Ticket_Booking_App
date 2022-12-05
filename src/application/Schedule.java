package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Schedule {
	private Date scheduledDate;
	private LocalTime hourMin;
	private ArrayList<Seat> availableSeats;
	//for local time: https://www.joda.org/joda-time/apidocs/org/joda/time/LocalTime.html
	
	public Schedule(Date date, LocalTime hourMin, ArrayList<Seat> availableSeats) {
		this.scheduledDate =date;
		this.hourMin =hourMin;
		this.scheduledDate.setHours(hourMin.getHour());
		this.scheduledDate.setMinutes(hourMin.getMinute());
		this.availableSeats = availableSeats;
	}
	public Boolean checkBooking(Seat selectedSeat) {
		for(Seat availSeat : this.availableSeats) {
			if(availSeat.checkEqual(selectedSeat)) {
				return true; //seat is available
			}
		}
		return false; //seat is booked
	}
	public void bookSeat(Seat selectedSeat) {
		for(Seat seat : this.availableSeats) {
			if(seat.checkEqual(selectedSeat)) {
				return seat;
			}
		}
		return null;
	}
	
	public String getString() {
		return this.scheduledDate.toString();
	}
	
	public LocalTime getTime() {
		return this.hourMin;
	}
	
	public ArrayList<Seat> getAvailableSeats(){
		return this.availableSeats;
	}

}
